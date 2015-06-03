package org.txazo.wx;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SpringAbstractTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.06.2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring.xml"})
public abstract class SpringAbstractTest {

}
