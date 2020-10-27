package com.xschen.spring.bean.a_type.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author xschen
 */


public class ToyFactoryBean implements FactoryBean<Toy> {
    private Child child;

    /**
     * FactoryBean 本身的加载是伴随IOC容器的初始化时机一起的
     */
    public ToyFactoryBean() {
        System.out.println("ToyFactoryBean初始化了...");
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public Toy getObject() throws Exception {
        switch (child.getWantToy()) {
            case "ball":
                return new Ball("ball");
            case "car":
                return new Car("car");
            default:
                return null;
        }
    }

    @Override
    public Class<?> getObjectType() {
        return Toy.class;
    }

    /**
     * 生成的bean是否单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}