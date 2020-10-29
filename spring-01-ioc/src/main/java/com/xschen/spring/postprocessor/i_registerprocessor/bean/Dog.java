package com.xschen.spring.postprocessor.i_registerprocessor.bean;

import org.springframework.stereotype.Component;

/**
 * @author xschen
 */



public class Dog extends Animal {

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
