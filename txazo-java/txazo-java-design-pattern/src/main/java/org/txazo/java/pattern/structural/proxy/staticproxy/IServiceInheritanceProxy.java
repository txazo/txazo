package org.txazo.java.pattern.structural.proxy.staticproxy;

import org.txazo.java.pattern.structural.proxy.IServiceImpl;

/**
 * IServiceInheritanceProxy - 继承实现静态代理
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class IServiceInheritanceProxy extends IServiceImpl {

    @Override
    public void service() {
        System.out.println("Proxy before");
        super.service();
        System.out.println("Proxy after");
    }

}
