package com.xschen.spring.basic_di.f_jsr330.bean;

/**
 * @author xschen
 */


public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
