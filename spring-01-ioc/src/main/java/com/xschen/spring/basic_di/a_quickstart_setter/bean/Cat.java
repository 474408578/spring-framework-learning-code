package com.xschen.spring.basic_di.a_quickstart_setter.bean;

import lombok.*;

/**
 * @author xschen
        */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cat {
    private String name;
    // 演示依赖注入
    private Person master;
}
