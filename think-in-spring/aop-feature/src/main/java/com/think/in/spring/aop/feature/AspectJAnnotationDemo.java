package com.think.in.spring.aop.feature;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xschen
 * @date 2021/9/20 12:05
 */


@Aspect
@Configuration
@EnableAspectJAutoProxy // 激活 AspectJ 自动代理
public class AspectJAnnotationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AspectJAnnotationDemo.class);
        context.refresh();

        AspectJAnnotationDemo demo = context.getBean(AspectJAnnotationDemo.class);
        System.out.println(demo);
        context.close();
    }
}
