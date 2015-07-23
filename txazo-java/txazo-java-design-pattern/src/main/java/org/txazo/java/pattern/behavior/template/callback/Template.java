package org.txazo.java.pattern.behavior.template.callback;

/**
 * Template
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class Template {

    public void templateMethod(TemplateCallback callback) {
        concreteMethod();
        callback.callback();
    }

    private void concreteMethod() {
        System.out.println("Template concreteMethod");
    }

}
