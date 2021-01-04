package com.xschen.spring.container.b_applicationcontext.config;

import com.xschen.spring.container.b_applicationcontext.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
public class DogConfiguration {
    @Bean
    public Dog dog() {
        return new Dog();
    }
}
