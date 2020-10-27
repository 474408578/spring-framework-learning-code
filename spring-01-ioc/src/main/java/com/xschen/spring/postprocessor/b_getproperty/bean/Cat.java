package com.xschen.spring.postprocessor.b_getproperty.bean;

import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
public class Cat {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
