package com.xschen.spring.basic_di.b_constructor.config;

import com.xschen.spring.basic_di.b_constructor.bean.Cat;
import com.xschen.spring.basic_di.b_constructor.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
public class InjectByConstructorConfiguration {
    @Bean
    public Person person() {
        return new Person("xiangsong", 22);
    }

    @Bean
    public Cat cat() {
        return new Cat("little cute", person());
    }
}
