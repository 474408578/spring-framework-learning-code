package com.xschen.spring.basic_di.d_autowired.config;

import com.xschen.spring.basic_di.d_autowired.bean.Cat;
import com.xschen.spring.basic_di.d_autowired.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author xschen
 */

@Configuration
@ComponentScan("com.xschen.spring.basic_di.d_autowired.bean")
public class InjectComplexFieldConfiguration {

    @Autowired // 高版本的spring框架中，不标注也可以将person注入到容器中
    @Bean
    public Cat cat(Person person) {
        Cat cat = new Cat();
        cat.setName("miaomiao");
        cat.setPerson(person);
        return cat;
    }

    @Bean
    @Primary
    public Person master() {
        Person master = new Person();
        master.setName("master");
        return master;
    }
}
