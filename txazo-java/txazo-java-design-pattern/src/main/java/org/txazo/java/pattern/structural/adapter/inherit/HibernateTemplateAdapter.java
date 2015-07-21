package org.txazo.java.pattern.structural.adapter.inherit;

import org.txazo.java.pattern.structural.adapter.HibernateTemplate;
import org.txazo.java.pattern.structural.adapter.JdbcTemplate;

/**
 * HibernateTemplateAdapter - 继承适配器
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class HibernateTemplateAdapter<T> extends HibernateTemplate<T> implements JdbcTemplate<T> {

    @Override
    public int add(T t) {
        return super.insert(t);
    }

    @Override
    public int remove(T t) {
        return super.delete(t);
    }

    @Override
    public int update(T t) {
        return super.update(t);
    }

    @Override
    public T get(int id) {
        return super.select(id);
    }

}
