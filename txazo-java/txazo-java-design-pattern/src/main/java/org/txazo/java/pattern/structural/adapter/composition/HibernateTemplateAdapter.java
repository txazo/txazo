package org.txazo.java.pattern.structural.adapter.composition;

import org.txazo.java.pattern.structural.adapter.HibernateTemplate;
import org.txazo.java.pattern.structural.adapter.JdbcTemplate;

/**
 * HibernateTemplateAdapter
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class HibernateTemplateAdapter<T> implements JdbcTemplate<T> {

    private HibernateTemplate<T> hibernateTemplate;

    public HibernateTemplateAdapter(HibernateTemplate<T> hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public int add(T t) {
        return hibernateTemplate.insert(t);
    }

    @Override
    public int remove(T t) {
        return hibernateTemplate.delete(t);
    }

    @Override
    public int update(T t) {
        return hibernateTemplate.update(t);
    }

    @Override
    public T get(int id) {
        return hibernateTemplate.select(id);
    }

}
