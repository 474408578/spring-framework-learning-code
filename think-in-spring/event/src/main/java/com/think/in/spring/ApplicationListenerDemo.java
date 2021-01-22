package com.think.in.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.GenericApplicationContext;

import java.util.EventListener;

/**
 * {@link ApplicationListener} 示例
 * @author xschen
 * 
 * @see EventListener
 * @see ApplicationEvent
 * @see ApplicationListener
 */


public class ApplicationListenerDemo {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        // 向Spring 应用上下文注册事件
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println("received Spring Event: " + event);
            }
        });

        // 启动Spring应用上下文
        context.refresh();
        // 启动Spring上下文
        context.start();
        // 关闭Spring应用上下文
        context.close();
    }
}
