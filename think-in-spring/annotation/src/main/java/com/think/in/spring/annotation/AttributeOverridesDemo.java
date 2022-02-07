package com.think.in.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring 注解属性覆盖示例
 * @author xschen
 * @date 2022/2/7 13:58
 */

@MyComponentScan2(packages = "com.think.in.spring.annotation")
public class AttributeOverridesDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AttributeOverridesDemo.class);
        context.refresh();
        TestClass testClass = context.getBean(TestClass.class);
        System.out.println(testClass);
        context.close();
    }
}
