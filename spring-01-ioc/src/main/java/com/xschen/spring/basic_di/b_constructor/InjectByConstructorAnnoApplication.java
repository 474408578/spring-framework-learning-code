package com.xschen.spring.basic_di.b_constructor;

import com.xschen.spring.basic_di.b_constructor.bean.Cat;
import com.xschen.spring.basic_di.b_constructor.bean.Person;
import com.xschen.spring.basic_di.b_constructor.config.InjectByConstructorConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class InjectByConstructorAnnoApplication {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(InjectByConstructorConfiguration.class);
        Person person = ctx.getBean(Person.class);
        System.out.println(person);

        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);
    }
}
