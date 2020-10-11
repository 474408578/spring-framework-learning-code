package com.xschen.spring.basic_di.d_autowired.bean;

import org.springframework.stereotype.Component;

/**
 * @author xschen
 */


@Component("administrator")
public class Person {
    private String name = "administrator";

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
