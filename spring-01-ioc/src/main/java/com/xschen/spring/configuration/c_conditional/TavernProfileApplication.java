package com.xschen.spring.configuration.c_conditional;

import com.xschen.spring.configuration.c_conditional.config.TavernConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @author xschen
 *
 * jvm参数也可控制profile：-Dspring.profiles.active=city
 */


public class TavernProfileApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TavernConfiguration.class);
        ctx.getEnvironment().setActiveProfiles("city");
        Stream.of(ctx.getBeanDefinitionNames())
                .forEach(System.out::println);

//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.getEnvironment().setActiveProfiles("city");
//        ctx.register(TavernConfiguration.class);
//        ctx.refresh();
//        Stream.of(ctx.getBeanDefinitionNames())
//                .forEach(System.out::println);
    }

}