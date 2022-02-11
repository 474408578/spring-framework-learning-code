package com.think.in.spring.validation.rawvalidation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.util.Set;

/**
 * Bean Validator Util
 * @author xschen
 * @date 2022/2/10 9:39
 */
public class ValidatorUtil {
    // 使用【默认配置】得到一个校验工厂  这个配置可以来自于provider、SPI提供
    public static ValidatorFactory obtainValidatorFactory() {
        return Validation.buildDefaultValidatorFactory();
    }

    // 获取校验器
    public static Validator obtainValidator() {
        return obtainValidatorFactory().getValidator();
    }

    // 用于方法检验的校验器
    public static ExecutableValidator obtainExecutableValidator() {
        return obtainValidator().forExecutables();
    }

    public static <T> void printViolations(Set<ConstraintViolation<T>> violations) {
        violations.stream()
                .map(v -> v.getPropertyPath() + v.getMessage() + ": " + v.getInvalidValue())
                .forEach(System.out::println);
    }
}
