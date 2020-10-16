package com.xschen.spring.event.a_quickstart.listener;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 * 注解式监听器
 *
 * ContextClosedEvent IOC容器已经关闭，但尚未销毁所有的Bean
 */

@Component
public class ContextClosedApplicationListener {

    @EventListener
    public void onContextClosedEvent(ContextClosedEvent event) {
        System.out.println("ContextClosedApplicationListener监听到ContextClosedEvent事件");
    }
}
