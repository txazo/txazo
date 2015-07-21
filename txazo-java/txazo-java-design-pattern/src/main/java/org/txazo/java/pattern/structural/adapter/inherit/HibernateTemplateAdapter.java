package org.txazo.java.pattern.structural.adapter.inherit;

import org.txazo.java.pattern.structural.adapter.HibernateTemplate;
import org.txazo.java.pattern.structural.adapter.JdbcTemplate;

/**
 * HibernateTemplateAdapter
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class HibernateTemplateAdapter<T> extends HibernateTemplate<T> implements JdbcTemplate<T> {

    @Override
    public int add(T t) {
        return insert(t);
    }

    @Override
    public int remove(T t) {
        return delete(t);
    }

    @Override
    public T get(int id) {
        return select(id);
    }

}
