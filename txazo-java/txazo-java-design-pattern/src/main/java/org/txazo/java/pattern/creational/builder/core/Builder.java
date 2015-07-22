package org.txazo.java.pattern.creational.builder.core;

/**
 * Builder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.07.2015
 */
public interface Builder {

    public void buildHead();

    public void buildBody();

    public void buildFoot();

    public Product buildProduct();

}
