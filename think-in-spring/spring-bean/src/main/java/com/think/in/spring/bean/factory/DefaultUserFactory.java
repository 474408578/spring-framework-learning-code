package com.think.in.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 默认{@link UserFactory}实现
 * @author xschen
 */


public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {
    // 1. @PostConstruct
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct userFactory初始化中……");
    }

    // 1. @PreDestory
    @PreDestroy
    public void preDestory() {
        System.out.println("@preDestory userFactory销毁中……");
    }

    // 2. initializingBean#afterPropertiesSet
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initializingBean#afterPropertiesSet userFactory初始化中……");
    }

    // 2. DisposableBean#destory
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destory userFactory销毁中……");
    }

    // 3. 自定义方法初始化
    public void initUserFactory() {
        System.out.println("自定义方法 userFactory初始化中……");
    }

    // 3. 自定义方法销毁
    public void destoryUserFactory() {
        System.out.println("自定义方法 userFactory销毁中……");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("当前DefaultUserFactory正在被垃圾回收……");
    }
}
