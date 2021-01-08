package com.xschen.spring.annotation.d_importxml;


import com.xschen.spring.annotation.d_importxml.config.AnnotationConfiguration;
import com.xschen.spring.annotation.d_importxml.config.ImportXmlAnnotationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Stream;

/**
 * @author xschen
 */


public class ImportXmlAnnoApplication {

    public static void main(String[] args) {
        /**
         * 在xml中引入注解
         */
        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation/import-anno.xml");
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println("--------------------------------------------------");

        /**
         * 在注解驱动中引入xml
         */
        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(ImportXmlAnnotationConfiguration.class);
        Stream.of(ctx2.getBeanDefinitionNames()).forEach(System.out::println);

    }
}
