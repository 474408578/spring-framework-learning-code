package com.xschen.spring.lifecycle.a_initmethod.bean;

/**
 * @author xschen
 */


public class Cat {
    private String name;

    public void setName(String name) {
        System.out.println("setName方法执行了");
        this.name = name;
    }

    public Cat() {
        System.out.println("Cat 构造方法执行了……");
    }

    public void init() {
        System.out.println(name + "被初始化了……");
    }

    public void destory() {
        System.out.println(name + "被销毁了");
    }
}
