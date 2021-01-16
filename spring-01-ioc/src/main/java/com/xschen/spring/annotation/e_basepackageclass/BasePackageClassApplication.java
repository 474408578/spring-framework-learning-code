package com.xschen.spring.annotation.e_basepackageclass;

import com.xschen.spring.annotation.e_basepackageclass.config.BasePackageClassConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * 演示basePackageClasses属性，可以传入一组Class进去，代表扫描传入的这些Class所在包及子包下的所有组件
 * @author xschen
 */


public class BasePackageClassApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BasePackageClassConfiguration.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        // 期待输出demoDao, demoService, innerComponent
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
