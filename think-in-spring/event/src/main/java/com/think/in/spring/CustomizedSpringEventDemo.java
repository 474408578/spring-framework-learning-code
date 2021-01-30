package com.think.in.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.AbstractApplicationEventMulticaster;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.ResolvableType;

/**
 * 自定义Spring事件示例
 * @author xschen
 *
 * @see ApplicationEvent
 * @see ApplicationListener
 * @see SimpleApplicationEventMulticaster#multicastEvent
 * @see AbstractApplicationEventMulticaster#getApplicationListeners(ApplicationEvent, ResolvableType)
 */


public class CustomizedSpringEventDemo {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        // 1、添加自定义的 Spring 事件监听器
        // ListenerRetriever(Listener 检索器) -> 0 ~ N 个 ApplicationListener<MySpringEventListener> 实例
        // MySpringEvent 以及他的子孙类
        context.addApplicationListener(new MySpringEventListener());
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                if (!(event instanceof ContextClosedEvent ||event instanceof ContextRefreshedEvent)) {
                    System.out.println("Event: " + event);
                }
            }
        });

        // 2、启动Spring应用上下文
        context.refresh();

        // 3、发布自定义事件
        // ListenerCacheKey -> MySpringEvent
        context.publishEvent(new MySpringEvent("Hello, World"));
        context.publishEvent(new MySpringEvent2("2020"));

        // 4、关闭Spring应用上下文
        context.close();
    }
}
