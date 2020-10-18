package com.xschen.spring.event.a_quickstart.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 *
 * 采用实现接口的方式，泛型ContextRefreshedEvent 要监听的具体事件（IOC容器刷新完毕，但尚未启动）
 */

@Component // 监听器需要注册到IOC容器才可以生效
public class ContextRefreshedApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("ContextRefreshedApplicationListener监听到ContextRefreshedEvent");
    }
}
