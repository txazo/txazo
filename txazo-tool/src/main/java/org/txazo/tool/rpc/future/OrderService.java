package org.txazo.tool.rpc.future;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class OrderService {

    private static final ExecutorService threadPool = new ThreadPoolExecutor(50, 50, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(500));

    private CarOrderService carOrderService = new CarOrderService();

    private HotelOrderService hotelOrderService = new HotelOrderService();

    private MovieOrderService movieOrderService = new MovieOrderService();

    public List<Order> listOrders() {
        OrderTask task = new DefaultOrderTask(true, 1, 500);
        task.submit();

        List<Order> orders = getOrders();
        if (CollectionUtils.isNotEmpty(orders)) {
            for (Order order : orders) {
                order.setExists(task.existsOrder(order.getType()));
            }
        }

        return orders;
    }

    private List<Order> getOrders() {
        List<Order> orders = new ArrayList<Order>();
        orders.add(new Order("car"));
        orders.add(new Order("hotel"));
        orders.add(new Order("movie"));

        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return orders;
    }

    private interface OrderTask {

        void submit();

        boolean existsOrder(String type);

    }

    private class DefaultOrderTask implements OrderTask {

        private final boolean async;
        private final int userId;
        private final int timeout;
        private Future<Object> carFuture;
        private Future<Object> hotelFuture;
        private Future<Object> movieFuture;

        public DefaultOrderTask(boolean async, int userId, int timeout) {
            this.async = async;
            this.userId = userId;
            this.timeout = timeout;
        }

        @Override
        public void submit() {
            if (async) {
                carFuture = threadPool.submit(new CarCallable(userId));
                hotelFuture = threadPool.submit(new HotelCallback(userId));
                movieFuture = threadPool.submit(new MovieCallback(userId));
            }
        }

        @Override
        public boolean existsOrder(String type) {
            try {
                if ("car".equals(type)) {
                    return async ? (Boolean) carFuture.get(timeout, TimeUnit.MILLISECONDS) : carOrderService.existsCarOrder(userId);
                } else if ("hotel".equals(type)) {
                    return async ? (Boolean) hotelFuture.get(timeout, TimeUnit.MILLISECONDS) : hotelOrderService.existsHotelOrder(userId);
                } else if ("movie".equals(type)) {
                    return async ? (Boolean) movieFuture.get(timeout, TimeUnit.MILLISECONDS) : movieOrderService.existsMovieOrder(userId);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

    }

    private abstract class OrderCallable implements Callable<Object> {

        protected final int userId;

        public OrderCallable(int userId) {
            this.userId = userId;
        }

    }

    private class CarCallable extends OrderCallable {

        public CarCallable(int userId) {
            super(userId);
        }

        @Override
        public Boolean call() throws Exception {
            return carOrderService.existsCarOrder(userId);
        }

    }

    private class HotelCallback extends OrderCallable {

        public HotelCallback(int userId) {
            super(userId);
        }

        @Override
        public Object call() throws Exception {
            return hotelOrderService.existsHotelOrder(userId);
        }

    }

    private class MovieCallback extends OrderCallable {

        public MovieCallback(int userId) {
            super(userId);
        }

        @Override
        public Object call() throws Exception {
            return movieOrderService.existsMovieOrder(userId);
        }

    }

}
