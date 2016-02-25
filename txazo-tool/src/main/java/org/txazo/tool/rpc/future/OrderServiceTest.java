package org.txazo.tool.rpc.future;

import java.util.List;

public class OrderServiceTest {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        List<Order> orders = orderService.listOrders();
        System.out.println(orders);
    }

}
