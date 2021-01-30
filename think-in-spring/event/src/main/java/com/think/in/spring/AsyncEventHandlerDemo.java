package com.think.in.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.util.ErrorHandler;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

/**
 * 异步事件处理器示例
 * @author xschen
 * @see SimpleApplicationEventMulticaster
 * @see Executor
 * @see ErrorHandler
 */


public class AsyncEventHandlerDemo {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        // 1. 添加自定义Spring事件监听器
        context.addApplicationListener(new MySpringEventListener());

        // 2. 启动Spring应用上下文
        context.refresh(); // initApplicationEventMulticaster()

        // 依赖查找ApplicationEventMulticaster
        ApplicationEventMulticaster applicationEventMulticaster = context.getBean(AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME,
                ApplicationEventMulticaster.class);

        if (applicationEventMulticaster instanceof SimpleApplicationEventMulticaster) {
            SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = (SimpleApplicationEventMulticaster) applicationEventMulticaster;
            // 切换taskExecutor
            ExecutorService taskExecutor = newSingleThreadExecutor(new CustomizableThreadFactory("my-spring-event-thread-pool"));
            // 同步 -> 异步
            simpleApplicationEventMulticaster.setTaskExecutor(taskExecutor);

            // 添加ContextCloseEvent 事件处理
            applicationEventMulticaster.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
                @Override
                public void onApplicationEvent(ContextClosedEvent event) {
                    if (!taskExecutor.isShutdown()) {
                        taskExecutor.shutdown();
                    }
                }
            });

            // Spring 错误处理接口-org.springframework.util.ErrorHandler
            simpleApplicationEventMulticaster.setErrorHandler(e -> {
                System.err.println("Spring事件异常： " + e.getMessage());
            });
        }

        context.addApplicationListener(new ApplicationListener<MySpringEvent>() {
            @Override
            public void onApplicationEvent(MySpringEvent event) {
                throw new RuntimeException("throw an Exception on purpose");
            }
        });

        // 3. 发布自定义事件
        context.publishEvent(new MySpringEvent("Hello, World"));

        // 4. 关闭Spring应用上下文（ContextClosedEvent）
        context.close();
    }
}