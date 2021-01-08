package com.xschen.spring.annotation.b_di.config;

import com.xschen.spring.annotation.b_di.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 编码方式的依赖注入
 * @author xschen
 */

@Configuration
public class AnnotationDIConfiguration {
    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("xschen");
        person.setAge(22);
        return person;
    }
}
