package com.think.in.spring.validation.rawvalidation;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author xschen
 * @date 2022/2/10 9:52
 */

@Data
public class Person {
    @NotNull
    private String name;
    @NotNull
    @Min(5)
    private Integer age;
}
