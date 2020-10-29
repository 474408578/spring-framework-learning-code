package com.xschen.spring.postprocessor.h_factoryprocessor.bean;

import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
public class Red extends Color {
    @Override
    public String toString() {
        return "Red{" +
                "name='" + name + '\'' +
                '}';
    }
}
