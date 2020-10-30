package com.xschen.spring.programmatic.c_components.bean;

/**
 * @author xschen
 */


public abstract class Animal {
    protected String name;
    protected Person person;

    public Animal() {
        System.out.println("Animal constructor run ……");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}
