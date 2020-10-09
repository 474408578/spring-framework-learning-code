package com.xschen.spring.annotation.d_importxml.config;

import com.xschen.spring.annotation.c_scan.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 * todo：xml中引入这个类，开启注解配置，使这个类中的注解生效
 */

@Configuration
public class AnnotationConfiguration {
    @Bean
    public Person person() {
        return new Person();
    }
}
