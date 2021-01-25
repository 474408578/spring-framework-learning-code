package com.think.in.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.EventListener;

/**
 * {@link ApplicationListener} 示例
 * @author xschen
 * 
 * @see EventListener
 * @see ApplicationEvent
 * @see ApplicationListener
 * @see org.springframework.context.event.EventListener
 *
 */

@EnableAsync // 激活异步操作
public class ApplicationListenerDemo implements ApplicationEventPublisherAware {

    public static void main(String[] args) {
//        GenericApplicationContext context = new GenericApplicationContext();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 将引导类 ApplicationListenerDemo 作为Configuration class
        context.register(ApplicationListenerDemo.class);

        // 方法1：基于Spring接口，向Spring 应用上下文注册事件
        // 方法a: 基于ConfigurableApplicationContext#addApplicationListener实现ApplicationListener的注册
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                println("ApplicationEventListener received Spring Event: " + event);
            }
        });

        // 方法b: 基于ApplicationListener注册为Spring Bean方式实现ApplicationListener的注册
        // 通过Configuration Class来注册
        context.register(MyApplicationListener.class);


        // 方法2：基于Spring注解，向Spring应用上下文注册事件

        // 启动Spring应用上下文
        context.refresh();
        // 启动Spring上下文
        context.start();
        // 关闭Spring应用上下文
        context.close();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        
    }

    static class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            println("MyApplicationListener（onApplicationEvent） received ContextRefreshedEvent");
        }
    }

    @org.springframework.context.event.EventListener
    @Order(1) // 数字越小，优先级越高
    public void onApplicationEvent(ContextRefreshedEvent event) {
        println("@EventListener（onApplicationEvent） received ContextRefreshedEvent");
    }

    @org.springframework.context.event.EventListener
    @Order(2)
    public void onApplicationEvent1(ContextRefreshedEvent event) {
        println("@EventListener（onApplicationEvent1） received ContextRefreshedEvent");
    }

    // 异步执行
    @org.springframework.context.event.EventListener
    @Async // 需要做激活操作
    public void onApplicationEventAsync(ContextRefreshedEvent event) {
        println("@EventListener[Async] received ContextRefreshedEvent");
    }



    @org.springframework.context.event.EventListener
    public void onApplicationEvent(ContextStartedEvent event) {
        println("@EventListener received ContextStartedEvent");
    }

    @org.springframework.context.event.EventListener
    public void onApplicationEvent(ContextClosedEvent event) {
        println("@EventListener received ContextClosedEvent");
    }

    private static void println(Object printable) {
        System.out.printf("[thread: %s]: %s\n", Thread.currentThread().getName(), printable);
    }
}
