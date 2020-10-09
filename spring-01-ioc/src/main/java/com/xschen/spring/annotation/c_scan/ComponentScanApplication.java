package com.xschen.spring.annotation.c_scan;

import com.xschen.spring.annotation.c_scan.bean.Person;
import com.xschen.spring.annotation.c_scan.config.ComponentScanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @author xschen
 */


public class ComponentScanApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ComponentScanConfiguration.class);

        // 不写ComponentScan也可以做到组件扫描
//        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.xschen.spring.annotation.c_scan.bean");


        Person person = ctx.getBean(Person.class);
        System.out.println(person);

        String[] beanNames = ctx.getBeanDefinitionNames();
        Stream.of(beanNames).forEach(System.out::println);
    }
}
