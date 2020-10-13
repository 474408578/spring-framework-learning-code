package com.xschen.spring.bean.c_instantiate.bean;

/**
 * @author xschen
 * todo: 借助实例工厂创建bean
 */


public class CarInstanceFactory {

    public Car getCar() {
        return new Car();
    }
}
