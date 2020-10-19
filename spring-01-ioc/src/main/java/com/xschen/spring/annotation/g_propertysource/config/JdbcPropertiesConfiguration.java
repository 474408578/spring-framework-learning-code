package com.xschen.spring.annotation.g_propertysource.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xschen
 */

@Configuration
@ComponentScan("com.xschen.spring.annotation.g_propertysource.bean")
@PropertySource("classpath:annotation/propertysource/jdbc.properties")
public class JdbcPropertiesConfiguration {

}
