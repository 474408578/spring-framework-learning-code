package com.think.in.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.util.ErrorHandler;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 注解驱动 异步事件处理器 示例
 * @author xschen
 * @see SimpleApplicationEventMulticaster
 * @see Executor
 * @see ErrorHandler
 */

@EnableAsync // 激活 Spring 异步特性
public class AnnotatedAsyncEventHandlerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 1. 注册当前类作为Configuration Class
        context.register(AnnotatedAsyncEventHandlerDemo.class);

        // 2. 启动 Spring 应用上下文
        context.refresh();

        // 3. 发布自定义事件
        context.publishEvent(new MySpringEvent("Hello, World"));

        // 4. 关闭Spring应用上下文（ContextClosedEvent）
        context.close();
    }

    @Async // 同步 -> 异步
    @EventListener
    public void onEvent(MySpringEvent event) {
        System.out.printf("[线程：%s] onEvent方法监听到事件: %s\n", Thread.currentThread().getName(), event);
    }

    @Bean
    public Executor taskExecutor() {
        ExecutorService taskExecutor = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("my-spring-event-thread-pool-a"));
        return taskExecutor;
    }
}