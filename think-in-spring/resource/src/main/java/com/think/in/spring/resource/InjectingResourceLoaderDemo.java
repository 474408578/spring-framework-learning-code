package com.think.in.spring.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * 注入 {@link ResourceLoader} 对象示例
 * @author xschen
 */
public class InjectingResourceLoaderDemo implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;// 方法一

    @Autowired
    private ResourceLoader autoWiredResourceLoader; // 方法二

    @Autowired
    private AbstractApplicationContext applicationContext; // 方法三

    @PostConstruct
    public void init() {
        // 三种不同的注入方式其实注入的都是一个对象 AbstractApplicationContext
        System.out.println("resourceLoader == autoWiredResourceLoader: " + (resourceLoader == autoWiredResourceLoader));
        System.out.println("resourceLoader == applicationContext: " + (resourceLoader == applicationContext));
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(InjectingResourceLoaderDemo.class);
        context.refresh();
        context.close();
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
