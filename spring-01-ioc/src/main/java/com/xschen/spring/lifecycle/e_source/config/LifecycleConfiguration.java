package com.xschen.spring.lifecycle.e_source.config;

import com.xschen.spring.lifecycle.e_source.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
@ComponentScan("com.xschen.spring.lifecycle.e_source.bean")
public class LifecycleConfiguration {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Person person() {
        Person person = new Person();
        person.setName("lisi");
        return person;
    }

}
