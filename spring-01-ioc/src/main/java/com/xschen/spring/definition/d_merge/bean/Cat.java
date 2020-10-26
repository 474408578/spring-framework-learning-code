package com.xschen.spring.definition.d_merge.bean;

/**
 * @author xschen
 */


public class Cat  extends Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" + "name=" + name + ", person='" + getPerson() + '\'' + "}";
    }
}
