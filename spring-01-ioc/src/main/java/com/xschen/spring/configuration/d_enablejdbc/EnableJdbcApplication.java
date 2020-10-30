package com.xschen.spring.configuration.d_enablejdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.xschen.spring.configuration.d_enablejdbc.config.EnableJdbc;
import org.springframework.context.annotation.*;

/**
 * @author xschen
 */

@Configuration

@EnableJdbc
public class EnableJdbcApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EnableJdbcApplication.class);
        DruidDataSource dataSource = ctx.getBean(DruidDataSource.class);
        System.out.println(dataSource.getUrl());
    }

}
