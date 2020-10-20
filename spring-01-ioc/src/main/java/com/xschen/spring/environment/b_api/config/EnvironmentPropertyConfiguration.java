package com.xschen.spring.environment.b_api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xschen
 */

@Configuration
@ComponentScan("com.xschen.spring.environment.b_api.bean")
@PropertySource("classpath:annotation/propertysource/jdbc.properties")
public class EnvironmentPropertyConfiguration {

}
