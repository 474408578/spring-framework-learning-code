package com.xschen.spring.configuration.e_enablejdbc.config;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * 使用EnvironmentAware注入Environment对象
 * @author xschen
 */

@Configuration
public abstract class AbstractJdbcConfiguration implements EnvironmentAware {

    protected Environment environment;

    @Bean
    public QueryRunner queryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}

