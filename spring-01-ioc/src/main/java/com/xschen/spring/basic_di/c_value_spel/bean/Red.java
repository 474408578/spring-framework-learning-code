package com.xschen.spring.basic_di.c_value_spel.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 使用Propertis文件来注入
 * @author xschen
 */

@Component
public class Red {
    @Value("${red.name}")
    private String name;

    @Value("${red.order}")
    private Integer order;

    @Override
    public String toString() {
        return "Red{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
