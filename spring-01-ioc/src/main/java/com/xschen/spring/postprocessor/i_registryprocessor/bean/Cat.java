package com.xschen.spring.postprocessor.i_registryprocessor.bean;

import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
public class Cat extends Animal {
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
