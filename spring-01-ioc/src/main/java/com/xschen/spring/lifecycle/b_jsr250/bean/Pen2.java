package com.xschen.spring.lifecycle.b_jsr250.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xschen
 * todo: jsr250规范和init-method共存
 */

@Component
public class Pen2 {
    private Integer ink;

    public void open() {
        System.out.println("init-method - 打开钢笔……");
    }

    public void close() {
        System.out.println("destory-method - 合上钢笔……");
    }

    @PostConstruct
    private void addInk() {
        System.out.println("@PostConstruct - 钢笔中已加满墨水……");
        this.ink = 100;
    }

    @PreDestroy
    private void outwellInk() {
        System.out.println("@PreDestroy - 钢笔中的墨水都放干净了……");
        this.ink = 0;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "ink=" + ink +
                '}';
    }
}
