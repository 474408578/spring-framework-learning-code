package com.xschen.spring.jdbc.c_dao.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author xschen
 */


public abstract class BaseDao {
//    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 可以自由选择注入DataSource还是JdbcTemplate，如果IOC中有定义JdbcTemplate, 那就注入JdbcTemplate;
     * 如果没有定义，也可以直接注入DataSource，让它自己构造；
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource) {
        // 如果jdbcTemplate还没有初始化，则创建一个
        if (this.jdbcTemplate == null) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
        }
    }
}
