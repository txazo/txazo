package org.txazo.java.pattern.behavior.template.core;

import org.junit.Test;

/**
 * TemplateTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class TemplateTest {

    @Test
    public void test() {
        AbstractTemplate template = new ConcreteTemplate();
        template.templateMethod();
    }

}
