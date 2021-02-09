package com.xschen.spring.a_quickstart;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author xschen
 */
public class JdbcTemplateQuickStartApplication {

    public static void main(String[] args) {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql//119.45.56.227:3306/testdb?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }
}
