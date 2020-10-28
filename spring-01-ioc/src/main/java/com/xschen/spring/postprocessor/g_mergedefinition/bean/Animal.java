package com.xschen.spring.postprocessor.g_mergedefinition.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xschen
 *
 * postProcessMergedBeanDefinition 发生在Bean的实例化之后，自动注入之前，
 * 这样可以在属性赋值和自动注入之前，把要注入的属性收集好。
 */


public abstract class Animal {

//    @Autowired
    private Person person;

    public Person getPerson() {
        return person;
    }

    @Autowired
    public void setPerson(Person person) {
        System.out.println("Animal setPerson run ……");
        this.person = person;
    }

}
