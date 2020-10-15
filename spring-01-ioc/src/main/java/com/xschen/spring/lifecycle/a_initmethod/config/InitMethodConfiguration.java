package com.xschen.spring.lifecycle.a_initmethod.config;

import com.xschen.spring.lifecycle.a_initmethod.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
@ComponentScan("com.xschen.spring.lifecycle.a_initmethod.bean")
public class InitMethodConfiguration {

    @Bean(initMethod = "init", destroyMethod = "destory")
    public Dog dog() {
        Dog dog = new Dog();
        dog.setName("wangwang");
        return dog;
    }
}
