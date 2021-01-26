package com.think.in.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 自定义Spring事件示例
 * @author xschen
 *
 * @see ApplicationEvent
 * @see ApplicationListener
 *
 */


public class CustomizedSpringEventDemo {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        // 1、添加自定义的 Spring 事件监听器
        context.addApplicationListener(new MySpringEventListener());

        // 2、启动Spring应用上下文
        context.refresh();

        // 3、发布自定义事件
        context.publishEvent(new MySpringEvent("Hello, World"));

        // 4、关闭Spring应用上下文
        context.close();
    }
}
