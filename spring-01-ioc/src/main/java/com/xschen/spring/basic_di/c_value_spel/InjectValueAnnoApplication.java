package com.xschen.spring.basic_di.c_value_spel;

import com.xschen.spring.basic_di.c_value_spel.bean.*;
import com.xschen.spring.basic_di.c_value_spel.config.InjectValueConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class InjectValueAnnoApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(InjectValueConfiguration.class);
        Black black = ctx.getBean(Black.class);
        System.out.println("Simple value: " + black);

        Red red = ctx.getBean(Red.class);
        System.out.println("Properties value: " + red);

        Blue blue = ctx.getBean(Blue.class);
        System.out.println("SpEL value: " + blue);

        Green green = ctx.getBean(Green.class);
        System.out.println("SpEL extension value: " + green);

        White white = ctx.getBean(White.class);
        System.out.println("use SpEL methods: " + white);
    }
}
