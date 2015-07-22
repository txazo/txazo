package org.txazo.java.pattern.structural.facade.core;

/**
 * Waiter
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class Waiter {

    public void order() {
        System.out.println("点菜");
    }

    public void submitOrder() {
        System.out.println("提交订单");
    }

    public void service() {
        System.out.println("上菜");
    }

}
