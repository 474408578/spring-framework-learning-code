package com.xschen.spring.basic_di.g_complexfield.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author xschen
 * todo: 基于注解注入，使用SPEL表达式
 */

@Component
public class Person2 {

    @Value("#{new String[] {'张三', '李四'}}")
    private String[] names;

    @Value("#{{'123', '234', '345'}}")
    private List<String> tels;

    @Value("#{{@miaomiao, new com.xschen.spring.basic_di.g_complexfield.bean.Cat()}}")
    private Set<Cat> cats;

    @Value("#{{'mimi': @miaomiao.name, 'miaomiao': new com.xschen.spring.basic_di.g_complexfield.bean.Cat().name}}")
    private Map<String, Object> events;

    @Value("#{{'123': '1231', '456': '4561'}}")
    private Properties props;

    @Override
    public String toString() {
        return "Person2{" +
                "names=" + Arrays.toString(names) +
                ", tels=" + tels +
                ", cats=" + cats +
                ", events=" + events +
                ", props=" + props +
                '}';
    }
}
