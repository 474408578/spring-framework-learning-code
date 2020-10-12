package com.xschen.spring.basic_di.g_complexfield;

import com.xschen.spring.basic_di.g_complexfield.bean.Person2;
import com.xschen.spring.basic_di.g_complexfield.config.InjectComplexFieldConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class ComplexFieldAnnoApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(InjectComplexFieldConfiguration.class);
        Person2 person = ctx.getBean(Person2.class);
        System.out.println(person);
    }
}
