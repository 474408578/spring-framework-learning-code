package com.xschen.spring.basic_di.a_quickstart_set.bean;

import lombok.*;

/**
 * @author xschen
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private String name;
    private Integer age;
}
