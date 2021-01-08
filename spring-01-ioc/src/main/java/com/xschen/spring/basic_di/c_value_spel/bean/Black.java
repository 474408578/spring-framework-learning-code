package com.xschen.spring.basic_di.c_value_spel.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * {@link Value}属性赋值
 * @author xschen
 */

@Component
public class Black {
    @Value("black-value-anno")
    private String name;

    @Value("0")
    private Integer order;

    @Override
    public String toString() {
        return "Black{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
