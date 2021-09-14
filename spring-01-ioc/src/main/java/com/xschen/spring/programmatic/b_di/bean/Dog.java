package com.xschen.spring.programmatic.b_di.bean;

/**
 * @author xschen
 */


public class Dog extends Animal {
    public Dog() {
        System.out.println("Dog constructor run ……");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}
