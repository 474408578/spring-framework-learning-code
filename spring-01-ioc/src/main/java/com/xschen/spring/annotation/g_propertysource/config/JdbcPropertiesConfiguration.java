package com.xschen.spring.annotation.g_propertysource.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PropertySourceFactory;

/**
 * @PropertySource 引入Properties文件示例
 * @author xschen
 * @see PropertySourceFactory 使用什么类型的解析器解析当前导入的资源文件
 */

@Configuration
@ComponentScan("com.xschen.spring.annotation.g_propertysource.bean")
@PropertySource("classpath:annotation/propertysource/jdbc.properties")
public class JdbcPropertiesConfiguration {

}
