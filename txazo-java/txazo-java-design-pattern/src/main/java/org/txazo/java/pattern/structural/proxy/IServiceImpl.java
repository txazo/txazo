package org.txazo.java.pattern.structural.proxy;

/**
 * IServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class IServiceImpl implements IService {

    @Override
    public void service() {
        System.out.println("IServiceImpl service");
    }

}
