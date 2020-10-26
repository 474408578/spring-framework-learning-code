package com.xschen.spring.definition.b_registry;

import com.xschen.spring.definition.b_registry.bean.Person;
import com.xschen.spring.definition.b_registry.config.BeanDefinitionRegistryConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class BeanDefinitionRegistryApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                BeanDefinitionRegistryConfiguration.class);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }
}
