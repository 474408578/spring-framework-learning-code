package com.think.in.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @EnableXXX 与 @Import 配合使用，实现模块装配
 * @author xschen
 * @date 2021/12/20 9:12
 */

@EnableHelloWorld
public class EnableModuleDemoBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableModuleDemoBootstrap.class);

        context.refresh();

        String helloWorld = context.getBean("helloWorld", String.class);

        System.out.println(helloWorld);

        context.close();
    }
}
