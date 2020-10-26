package com.xschen.spring.definition.d_merge.bean;

/**
 * @author xschen
 */


public abstract class Animal {
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
