package com.xschen.spring.configuration.a_module;

import com.xschen.spring.configuration.a_module.component.Bar;
import com.xschen.spring.configuration.a_module.component.Bartender;
import com.xschen.spring.configuration.a_module.component.Boss;
import com.xschen.spring.configuration.a_module.config.TavernConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.stream.Stream;

/**
 * @author xschen
 *
 * IOC模块装配
 */


public class TavernApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                TavernConfiguration.class);
//        Stream.of(ctx.getBeanDefinitionNames())
//                .forEach(System.out::println);
//
//        System.out.println("-------------------------------------");

        Map<String, Bartender> bartenders = ctx.getBeansOfType(Bartender.class);
        bartenders.forEach((name, bartender) -> {
            System.out.println(name + ": " + bartender);
        });
        Map<String, Bar> bars = ctx.getBeansOfType(Bar.class);
        bars.forEach((name, bar) -> {
            System.out.println("\n" + name + ": " + bar);
        });
    }
}
