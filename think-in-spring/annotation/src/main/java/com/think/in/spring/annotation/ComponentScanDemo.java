package com.think.in.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * {@link Component} 扫描示例
 *
 * @author xschen
 * @date 2022/2/7 11:14
 * @see ComponentScan
 */
@MyComponentScan2(packages = "com.think.in.spring.annotation")
//@MyComponentScan(scanBasePackages = "com.think.in.spring.annotation")
//@ComponentScan(value = "com.think.in.spring.annotation")
public class ComponentScanDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ComponentScanDemo.class);
        context.refresh();
        // 依赖查找 TestClass bean
        // 从 Spring 4.0 开始支持多层次 @Component "派生"
        TestClass testClass = context.getBean(TestClass.class);

        // Annotation -> AnnotationAttributes(Map)
        System.out.println(testClass);

        context.close();
    }
}
