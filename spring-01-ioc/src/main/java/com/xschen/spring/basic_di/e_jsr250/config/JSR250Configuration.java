package com.xschen.spring.basic_di.e_jsr250.config;

import com.xschen.spring.basic_di.e_jsr250.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
@ComponentScan("com.xschen.spring.basic_di.e_jsr250.bean")
public class JSR250Configuration {

    @Bean
    public Person master() {
        return new Person("master");
    }

    @Bean
    public Person admin() {
        return new Person("admin");
    }
}
