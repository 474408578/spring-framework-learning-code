package com.xschen.spring.programmatic.b_di.bean;

/**
 * @author xschen
 */


public class Cat extends Animal {
    public Cat() {
        System.out.println("Cat constructor run ……");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}
