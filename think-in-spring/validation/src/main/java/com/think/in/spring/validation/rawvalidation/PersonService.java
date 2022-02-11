package com.think.in.spring.validation.rawvalidation;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 校验注解应该写在接口上
 * @author xschen
 * @date 2022/2/11 15:36
 * @see Valid 用于验证级联的属性、方法参数或方法返回类型
 */
public interface PersonService {

    void save(@NotNull @Valid Person person) throws NoSuchMethodException;


    @NotNull
    Person getOne(Integer id) throws NoSuchMethodException;
}
