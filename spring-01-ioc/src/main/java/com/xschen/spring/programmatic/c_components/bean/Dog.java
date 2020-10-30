package com.xschen.spring.programmatic.c_components.bean;

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
