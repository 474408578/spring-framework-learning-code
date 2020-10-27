package com.xschen.spring.postprocessor.c_executetime.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author xschen
 */

public class Dog implements InitializingBean {
    public void initMethod() {
        System.out.println("initMethod ……");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("PostConstruct ……");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean ……");
    }
}
