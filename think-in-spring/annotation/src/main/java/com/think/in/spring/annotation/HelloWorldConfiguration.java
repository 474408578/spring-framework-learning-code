package com.think.in.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 * @date 2021/12/20 9:16
 */

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld() {
        return "hello, World";
    }

}
