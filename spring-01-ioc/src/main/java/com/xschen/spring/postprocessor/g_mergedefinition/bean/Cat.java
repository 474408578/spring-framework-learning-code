package com.xschen.spring.postprocessor.g_mergedefinition.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
public class Cat extends Animal {

    @Value("mimi")
    private String name;

    public Cat() {
        System.out.println("Cat constructor run ……");
    }

    @Override
    public String toString() {
        return "Cat {person: " + this.getPerson() + ", name: " + name + "}";
    }
}
