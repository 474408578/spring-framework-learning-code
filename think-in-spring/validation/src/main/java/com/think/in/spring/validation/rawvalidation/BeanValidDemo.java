package com.think.in.spring.validation.rawvalidation;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.Set;

import static com.think.in.spring.validation.rawvalidation.ValidatorUtil.*;
/**
 * @author xschen
 * @date 2022/2/11 17:03
 * @see Validator
 */
public class BeanValidDemo {


    /**
     * 验证指定属性约束条件
     */
    public static void validProperty() {
        User user = User.builder().fullName("song").build();
        Set<ConstraintViolation<User>> violations = obtainValidator().validateProperty(user, "fullName");
        printViolations(violations);
    }

    /**
     * 检验Value值
     */
    public static void validValue() {
        Set<ConstraintViolation<User>> violations = obtainValidator().validateValue(User.class, "fullName", "song");
        printViolations(violations);

    }

    public static void main(String[] args) {
        validProperty();
        validValue();
    }
}


