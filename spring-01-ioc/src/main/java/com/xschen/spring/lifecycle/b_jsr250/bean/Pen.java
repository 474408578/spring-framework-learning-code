package com.xschen.spring.lifecycle.b_jsr250.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xschen
 * todo：被 @PostConstruct 和 @PreDestroy 注解标注的方法，
 * 与 init-method / desctory-method 方法的声明要求是一样的，访问修饰符也可以是 private 。
 */

//@Component
public class Pen {

    private Integer ink;

    // public 或者private都可以
    @PostConstruct
    private void addInk() {
        System.out.println("钢笔中已加满墨水……");
        this.ink = 100;
    }

    @PreDestroy
    private void outwellInk() {
        System.out.println("钢笔中的墨水都放干净了……");
        this.ink = 0;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "ink=" + ink +
                '}';
    }
}
