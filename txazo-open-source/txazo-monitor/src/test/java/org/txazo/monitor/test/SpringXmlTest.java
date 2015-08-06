package org.txazo.monitor.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SpringXmlTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 06.08.2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-*.xml"})
public class SpringXmlTest {

    @Test
    public void test() {

    }

}
