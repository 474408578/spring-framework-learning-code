package com.xschen.spring.annotation.b_di;

import com.xschen.spring.annotation.b_di.bean.Person;
import com.xschen.spring.annotation.b_di.config.AnnotationDIConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 *
 * 注解驱动的IOC依赖注入
 */



public class AnnotationDIApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationDIConfiguration.class);
        Person person = ctx.getBean(Person.class);
        System.out.println(person);
    }

}
