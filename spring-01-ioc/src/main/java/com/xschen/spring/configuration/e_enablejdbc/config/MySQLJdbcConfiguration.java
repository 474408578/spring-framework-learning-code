package com.xschen.spring.configuration.e_enablejdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.xschen.spring.configuration.e_enablejdbc.annotation.ConditionalOnClassName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author xschen
 */

@Configuration
@ConditionalOnClassName("com.mysql.cj.jdbc.Driver")
public class MySQLJdbcConfiguration extends AbstractJdbcConfiguration {

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername("jdbc.username");
        dataSource.setPassword("jdbc.password");
        return dataSource;
    }
}
