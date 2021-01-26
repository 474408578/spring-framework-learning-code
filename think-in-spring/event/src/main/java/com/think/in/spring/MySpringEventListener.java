package com.think.in.spring;

import org.springframework.context.ApplicationListener;

/**
 * @author xschen
 */


public class MySpringEventListener implements ApplicationListener<MySpringEvent> {
    @Override
    public void onApplicationEvent(MySpringEvent event) {
        System.out.printf("[thread: %s] 监听到事件：%s\n", Thread.currentThread().getName(), event);
    }
}
