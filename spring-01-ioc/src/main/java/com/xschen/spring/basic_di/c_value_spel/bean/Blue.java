package com.xschen.spring.basic_di.c_value_spel.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 * todo: 使用@Value配合SpEL完成字面量的属性注入，需要额外在花括号内部加单引号
 *
 * SpEL的语法统一用#{}来表示，花括号内部编写表达式语言
 *
 */

@Component
public class Blue {

    @Value("#{'blue-value-bySpEL'}")
    private String name;

    @Value("#{2}")
    private Integer order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Blue{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
