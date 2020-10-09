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
public class Cat {
    private String name;
    private Person person;
}
