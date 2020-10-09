package com.xschen.spring.annotation.d_importxml.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author xschen
 * todo: 这个类使用注解驱动引入，这个类中的xml配置也会被自动注入到IOC容器中。
 */

@Configuration
@ImportResource("classpath:annotation/beans.xml")
public class ImportXmlAnnotationConfiguration {
}
