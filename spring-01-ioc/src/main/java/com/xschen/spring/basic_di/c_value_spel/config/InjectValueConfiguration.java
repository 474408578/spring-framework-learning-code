package com.xschen.spring.basic_di.c_value_spel.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xschen
 * @ComponentScan 包扫描的位置
 * @PropertySource 引入配置文件
 *
 */

@Configuration
@ComponentScan("com.xschen.spring.basic_di.c_value_spel.bean")
@PropertySource("classpath:basic_di/value/red.properties")
public class InjectValueConfiguration {
}
