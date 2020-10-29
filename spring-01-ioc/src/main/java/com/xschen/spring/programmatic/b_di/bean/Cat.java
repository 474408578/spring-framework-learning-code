package com.xschen.spring.programmatic.b_di.bean;

/**
 * @author xschen
 */


public class Cat extends Animal {
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}
