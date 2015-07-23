package org.txazo.java.pattern.behavior.mediator.core;

import org.junit.Test;

/**
 * MediatorTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class MediatorTest {

    @Test
    public void test() {
        RealEstateMediator mediator = new RealEstateMediator();
        Tenant tenant = new Tenant("租客-李先生", mediator);
        Landlord landlord = new Landlord("房东－张先生", mediator);
        tenant.intendRent("我想租两室一厅的房子");
        landlord.publishRent("出租三室一厅的房子");
    }

}
