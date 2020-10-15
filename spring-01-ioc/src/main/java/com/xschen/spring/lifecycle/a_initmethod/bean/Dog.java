package com.xschen.spring.lifecycle.a_initmethod.bean;

import org.springframework.context.annotation.Bean;

/**
 * @author xschen
 */


public class Dog {
    private String name;

    public Dog() {
        System.out.println("Dog 构造方法执行了……");
    }

    public void setName(String name) {
        System.out.println("setName方法执行了");
        this.name = name;
    }

    public void init() {
        System.out.println(name + "被初始化了……");
    }

    public void destory() {
        System.out.println(name + "被销毁了");
    }
}
