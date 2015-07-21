package org.txazo.java.pattern.structural.adapter;

/**
 * JdbcTemplate
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public interface JdbcTemplate<T> {

    public int add(T t);

    public int remove(T t);

    public int update(T t);

    public T get(int id);

}
