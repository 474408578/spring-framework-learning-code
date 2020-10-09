package com.xschen.spring.basic_di.c_value_spel.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
public class White {
    @Value("#{blue.name.substring(0, 3)}")
    private String name;

    @Value("#{T(java.lang.Integer).MAX_VALUE}")
    private Integer order;

    @Override
    public String toString() {
        return "White{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
