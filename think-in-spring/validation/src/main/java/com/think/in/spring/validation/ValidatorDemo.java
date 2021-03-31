package com.think.in.spring.validation;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.validation.*;

import java.util.List;
import java.util.Locale;

/**
 * 自定义 Spring {@link Validator} 示例
 * @author xschen
 */


public class ValidatorDemo {

    public static void main(String[] args) {
        // 1、创建 Validator
        Validator validator = new UserValidator();
        // 2、判断是否支持目标对象的类型
        User user = new User();
        user.setName("song");
        System.out.println("user 对象是否被 UserValidator 支持校验：" + validator.supports(user.getClass()));

        // 3、创建 Errors 对象
        Errors errors = new BeanPropertyBindingResult(user, "user");
        validator.validate(user, errors);

        // 4、获取MessageSource 对象
        MessageSource messageSource = ErrorsMessageDemo.createMessageSource();

        // 5、输出所有错误文案
        List<ObjectError> allErrors = errors.getAllErrors();
        allErrors.forEach(error -> {
            String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println(message);
        });
    }

    static class UserValidator implements  Validator {
        @Override
        public boolean supports(Class<?> clazz) {
            return User.class.isAssignableFrom(clazz); // User 类 或者 其子类 都支持
        }

        @Override
        public void validate(Object target, Errors errors) {
            User user = (User) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
            String userName= user.getName();
            // ...
        }
    }
}
