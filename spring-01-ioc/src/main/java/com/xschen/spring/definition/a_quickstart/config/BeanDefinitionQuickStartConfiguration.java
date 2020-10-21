package com.xschen.spring.definition.a_quickstart.config;

import com.xschen.spring.definition.a_quickstart.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
public class BeanDefinitionQuickStartConfiguration {

    @Bean
    public Person person() {
        return new Person();
    }
}
