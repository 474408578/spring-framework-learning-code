package com.xschen.spring.bean.c_instantiate.bean;

/**
 * @author xschen
 * todo: 编程式使用静态工厂
 */


public class CarStaticFactory {

    public static Car getCar() {
        return new Car();
    }
}
