package com.xschen.spring.basic_di.a_quickstart_setter.config;

import com.xschen.spring.basic_di.a_quickstart_setter.bean.Cat;
import com.xschen.spring.basic_di.a_quickstart_setter.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 * todo: 基于注解的依赖注入
 */


@Configuration
public class QuickStartInjectBySetConfiguration {
    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("xschen");
        person.setAge(18);
        return person;
    }

    @Bean
    public Cat cat() {
        Cat cat = new Cat();
        cat.setName("cute");
        cat.setMaster(person());
        return cat;
    }
}
