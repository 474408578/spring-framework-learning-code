package com.xschen.spring.programmatic.b_di.bean;

/**
 * @author xschen
 */


public class Dog extends Animal {
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}
