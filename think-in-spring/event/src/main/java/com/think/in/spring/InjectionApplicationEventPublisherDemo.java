package com.think.in.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * 注入 {@link ApplicationEventPublisher} 示例
 * 顺序指定1 2 3 4
 * @author xschen
 * @see org.springframework.context.support.ApplicationContextAwareProcessor#invokeAwareInterfaces
 *
 */


public class InjectionApplicationEventPublisherDemo implements ApplicationEventPublisherAware, ApplicationContextAware {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ApplicationContext applicationContext;

    // 一个线程内顺序执行
    @PostConstruct
    public void init() {
        // #3
        applicationEventPublisher.publishEvent(new MySpringEvent("The event from @Autowired ApplicationEventPublisher"));
        // #4
        applicationContext.publishEvent(new MySpringEvent("The event from @Autowired ApplicationContext"));
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(InjectionApplicationEventPublisherDemo.class);
        context.addApplicationListener(new MySpringEventListener());
        context.refresh();
        context.close();
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) { // #1
        applicationEventPublisher.publishEvent(new MySpringEvent("The event from ApplicationEventPublisherAware"));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException { // #2
        applicationContext.publishEvent(new MySpringEvent("The event from ApplicationContext"));
    }
}
