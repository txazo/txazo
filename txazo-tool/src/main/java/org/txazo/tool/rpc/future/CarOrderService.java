package org.txazo.tool.rpc.future;

import java.util.concurrent.ThreadLocalRandom;

public class CarOrderService {

    public boolean existsCarOrder(int userId) {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

}
