package com.xschen.spring.configuration.f_enablejdbc.config;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author xschen
 */

@Configuration
public class JdbcConfiguration {

    @Bean
    public QueryRunner queryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean
    public DataSourceRegistryPostProcessor dataSourceRegistryPostProcessor() {
        return new DataSourceRegistryPostProcessor();
    }
}
