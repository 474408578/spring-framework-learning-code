package com.xschen.spring.annotation.a_quickstart;

import com.xschen.spring.annotation.a_quickstart.bean.Person;
import com.xschen.spring.annotation.a_quickstart.config.QuickStartConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class AnnotationConfigApplication {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(QuickStartConfiguration.class);
        Person person = ctx.getBean(Person.class);
        System.out.println(person);
    }
}
