package com.xschen.spring.postprocessor.h_factoryprocessor.bean;

import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
public class Green extends Color {
    @Override
    public String toString() {
        return "Green{" +
                "name='" + name + '\'' +
                '}';
    }
}
