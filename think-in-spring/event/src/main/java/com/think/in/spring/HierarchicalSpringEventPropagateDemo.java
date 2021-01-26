package com.think.in.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 层次性Spring事件传播示例
 * @author xschen
 * @see ApplicationContextEvent
 * @see AbstractApplicationContext #publishEvent(Object, ResolvableType)
 *
 */


public class HierarchicalSpringEventPropagateDemo {

    public static void main(String[] args) {
        // 1、创建parent Spring 应用上下文
        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
        parentContext.setId("parent-context");
        // 注册MyListener到 parent Spring 应用上下文
        parentContext.register(MyListener.class);

        // 2、创建current Spring 应用上下文
        AnnotationConfigApplicationContext currentContext = new AnnotationConfigApplicationContext();
        currentContext.setId("current-context");
        // 注册MyListener到 current Spring 应用上下文
        currentContext.register(MyListener.class);

        // 4、current->parent
        currentContext.setParent(parentContext);

        // 5、启动parent Spring应用上下文
        parentContext.refresh();

        // 启动current Spring应用上下文
        currentContext.refresh();

        // 关闭所有应用上下文
        currentContext.close();
        parentContext.close();

    }

    static class MyListener implements ApplicationListener<ApplicationContextEvent> {
        // 去重，防止层次性传播,  必须为static字段，因为父子应用上下文会对应两个MyListener
        private static Set<ApplicationContextEvent> processedEvents = new LinkedHashSet<>();

        @Override
        public void onApplicationEvent(ApplicationContextEvent event) {
            // 如果set已经包含，会返回false
            if (processedEvents.add(event)) {
                System.out.printf("监听到Spring应用上下文[ ID : %s] 事件：%s\n",
                        event.getApplicationContext().getId(), event.getClass().getSimpleName());
            }
        }
    }
}