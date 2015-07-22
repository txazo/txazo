package org.txazo.java.pattern.behavior.template.callback;

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
        Template template = new Template();
        template.templateMethod(new TemplateCallback() {

            @Override
            public void callback() {
                System.out.println("callback");
            }

        });
    }

}
