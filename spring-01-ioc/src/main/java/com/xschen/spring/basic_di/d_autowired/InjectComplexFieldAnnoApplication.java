package com.xschen.spring.basic_di.d_autowired;

import com.xschen.spring.basic_di.d_autowired.bean.Cat;
import com.xschen.spring.basic_di.d_autowired.bean.Dog;
import com.xschen.spring.basic_di.d_autowired.bean.Person;
import com.xschen.spring.basic_di.d_autowired.config.InjectComplexFieldConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class InjectComplexFieldAnnoApplication {
    public static void main(String[] args) {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.xschen.spring.basic_di.d_autowired.bean");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(InjectComplexFieldConfiguration.class);

        Dog dog = ctx.getBean(Dog.class);
        System.out.println(dog);

        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);

        System.out.println(cat.getName());
    }
}
