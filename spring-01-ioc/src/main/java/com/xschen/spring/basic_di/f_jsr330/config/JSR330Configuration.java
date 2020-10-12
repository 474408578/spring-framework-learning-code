package com.xschen.spring.basic_di.f_jsr330.config;

import com.xschen.spring.basic_di.f_jsr330.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
@ComponentScan("com.xschen.spring.basic_di.f_jsr330.bean")
public class JSR330Configuration {
    @Bean
    public Person admin() {
        return new Person("admin");
    }

    @Bean
    public Person person() {
        return new Person("person");
    }

}
