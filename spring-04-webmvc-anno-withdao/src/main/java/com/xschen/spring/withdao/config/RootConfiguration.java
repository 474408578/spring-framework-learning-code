package com.xschen.spring.withdao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

/**
 * @author xschen
 */

@Configuration
@Import(JdbcDaoConfiguration.class)
@ComponentScan(value = "com.xschen.spring.withdao",
        excludeFilters = {
            @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION),
            @ComponentScan.Filter(value = Configuration.class, type = FilterType.ANNOTATION)})
public class RootConfiguration {
}
