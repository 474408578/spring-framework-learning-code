package com.xschen.spring.configuration.d_enablejdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.xschen.spring.configuration.d_enablejdbc.config.EnableJdbc;
import org.springframework.context.annotation.*;

/**
 * @author xschen
 *
 * 存在的问题：
 *      1、配置写死在代码里面
 *      2、多个DataSource放在一个配置类，如果后续其他的组件越来越多，会导致JdbcConfiguration越来越大。
 * 最好将不同数据库的组件都分散到不同的配置类中
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
