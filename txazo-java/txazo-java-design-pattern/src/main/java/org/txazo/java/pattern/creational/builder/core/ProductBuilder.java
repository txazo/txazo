package org.txazo.java.pattern.creational.builder.core;

/**
 * ProductBuilder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public class ProductBuilder implements Builder {

    private Product product;

    public ProductBuilder() {
        product = new Product();
    }

    @Override
    public void buildHead() {
        product.setHead("head");
    }

    @Override
    public void buildBody() {
        product.setBody("body");
    }

    @Override
    public void buildFoot() {
        product.setFoot("foot");
    }

    @Override
    public Product buildProduct() {
        return product;
    }

}
