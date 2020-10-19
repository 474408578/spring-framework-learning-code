package com.xschen.spring.annotation.h_propertyxml.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xschen
 */

@Configuration
@ComponentScan("com.xschen.spring.annotation.h_propertyxml.bean")
@PropertySource("classpath:annotation/propertyxml/jdbc.xml")
public class JdbcXmlPropertyConfiguration {

}
