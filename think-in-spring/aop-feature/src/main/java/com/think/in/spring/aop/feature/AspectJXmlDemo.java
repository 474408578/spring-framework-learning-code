package com.think.in.spring.aop.feature;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xschen
 * @date 2021/9/20 12:05
 */


@Aspect
@Configuration
public class AspectJXmlDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring-aop-context.xml");

        context.close();
    }
}
