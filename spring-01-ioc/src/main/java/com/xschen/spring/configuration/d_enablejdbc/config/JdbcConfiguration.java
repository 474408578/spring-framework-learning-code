package com.xschen.spring.configuration.d_enablejdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.xschen.spring.configuration.d_enablejdbc.annotation.ConditionalOnClassName;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author xschen
 * todo: 注册数据源，加载连接池
 */

@Configuration
public class JdbcConfiguration {
    @Bean
    @ConditionalOnClassName("com.mysql.cj.jdbc.Driver")
    public DataSource mysqlDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test??useUnicode=true&characterEncoding=utf-8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    @ConditionalOnClassName("oracle.jdbc.driver.OracleDriver")
    public DataSource oracleDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        dataSource.setUsername("system");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    @ConditionalOnClassName("org.h2.Driver")
    public DataSource h2DataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/test");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
        return dataSource;
    }

    @Bean
    public QueryRunner queryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }
}
