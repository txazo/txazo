package org.txazo.java.pattern.structural.proxy.staticproxy;

import org.txazo.java.pattern.structural.proxy.IService;

/**
 * IServiceCompositionProxy
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class IServiceCompositionProxy implements IService {

    private IService iService;

    public IServiceCompositionProxy(IService iService) {
        this.iService = iService;
    }

    @Override
    public void service() {
        System.out.println("Proxy before");
        iService.service();
        System.out.println("Proxy after");
    }

}
