package com.xschen.spring.postprocessor.a_quickstart.bean;

import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
public class Cat {
    public Cat() {
        System.out.println("new cat");
    }
}
