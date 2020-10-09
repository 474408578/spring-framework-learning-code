package com.xschen.spring.basic_di.b_constructor.bean;

import lombok.*;

/**
 * @author xschen
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private String name;
    private Integer age;
}
