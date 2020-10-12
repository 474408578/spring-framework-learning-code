package com.xschen.spring.basic_di.e_jsr250.bean;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author xschen
 */

@Component
public class Bird {

    @Resource(name = "master")
    private Person person;

    @Override
    public String toString() {
        return "Bird{" +
                "person=" + person +
                '}';
    }
}
