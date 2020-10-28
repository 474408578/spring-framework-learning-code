package com.xschen.spring.postprocessor.g_mergedefinition.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xschen
 */


public abstract class Animal {

    @Autowired
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
