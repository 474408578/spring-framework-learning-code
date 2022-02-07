package com.think.in.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

import java.lang.annotation.Repeatable;

/**
 * {@link Repeatable} demo  jdk8新增的注解，可以将多个注解替换为一个数组注解
 * @author xschen
 * @date 2021/12/16 10:16
 */

@ComponentScan("com.think.in.spring.bean")
@ComponentScan("com.think.in.spring.service")
public class RepeatableDemo {

    public static void main(String[] args) {
        ComponentScans annotation = RepeatableDemo.class.getAnnotation(ComponentScans.class);
        for (ComponentScan componentScan : annotation.value()) {
            System.out.println(componentScan.value()[0]);
        }
        //com.think.in.spring.bean
        //com.think.in.spring.service
    }
}
