package org.txazo.java.pattern.structural.adapter.composition;

import org.junit.Test;
import org.txazo.java.pattern.structural.adapter.HibernateTemplate;
import org.txazo.java.pattern.structural.adapter.JdbcTemplate;

/**
 * AdapterTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class AdapterTest {

    @Test
    public void test() {
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        JdbcTemplate jdbcTemplate = new HibernateTemplateAdapter(hibernateTemplate);
        jdbcTemplate.add(null);
        jdbcTemplate.remove(null);
        jdbcTemplate.update(null);
        jdbcTemplate.get(1);
    }

}
