package org.txazo.java.pattern.creational.builder.core;

/**
 * Director
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product getProduct() {
        builder.buildHead();
        builder.buildBody();
        builder.buildFoot();
        return builder.buildProduct();
    }

}
