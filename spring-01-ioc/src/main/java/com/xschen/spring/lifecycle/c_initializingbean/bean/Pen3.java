package com.xschen.spring.lifecycle.c_initializingbean.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xschen
 */


public class Pen3 implements InitializingBean, DisposableBean {
    private Integer ink;

    public Pen3() {
        System.out.println("construct - 买了一支钢笔");
    }

    public void open() {
        System.out.println("init-method - 打开钢笔……");
    }

    public void close() {
        System.out.println("destroy-method - 合上钢笔……");
    }

    // jsr250
    @PostConstruct
    public void addInk() {
        this.ink = 100;
        System.out.println("@PostConstruct - 已加满墨水……");
    }

    // jsr250
    @PreDestroy
    public void outwellInk() {
        System.out.println("@PreDestroy - 钢笔中的墨水都放干净了……");
        this.ink = 0;
    }

    // InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        this.ink = 100;
        System.out.println("InitializingBean - 准备写字……");
    }

    //DisposableBean
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean - 写完字了……");
        this.ink = 0;
    }




    @Override
    public String toString() {
        return "Pen{" +
                "ink=" + ink +
                '}';
    }
}
