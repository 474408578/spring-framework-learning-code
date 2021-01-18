package com.think.in.spring.dependency.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * ResolvableDependency作为依赖来源示例
 * 非Spring容器管理对象作为依赖来源
 * @see DefaultListableBeanFactory#registerResolvableDependency(Class, Object)
 *
 * @author xschen
 */


public class ResolvableDependencySourceDemo {

    @Autowired
    private String value;

    @PostConstruct
    public void init() {
        System.out.println(value);
    }

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册Configuration class（配置类）-> Spring Bean
        applicationContext.register(ResolvableDependencySourceDemo.class);

        // 早于Bean的初始化来进行回调,由AbstractApplicationContext#invokeBeanFactoryPostProcessors方法产生
        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            // 注册Resolvable Dependency
            beanFactory.registerResolvableDependency(String.class, "Hello, World");
        });

        // 启动应用上下文
        applicationContext.refresh();

        // 关闭应用上下文
        applicationContext.close();

    }
}
