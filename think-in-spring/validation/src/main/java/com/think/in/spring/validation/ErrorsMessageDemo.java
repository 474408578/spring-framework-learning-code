package com.think.in.spring.validation;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Locale;

/**
 * 错误文案示例
 * @author xschen
 *
 * @see org.springframework.validation.Errors
 */

public class ErrorsMessageDemo {

    public static void main(String[] args) {
        // 0、创建user对象
        User user = new User();
        user.setName("song");
        // 1、选择 Errors - BeanPropertyBindingResult
        Errors errors = new BeanPropertyBindingResult(user, "user");
        // 2、调用 reject 或者 rejectValue
        // reject 生成 ObjectError
        // rejectValue 生成 FieldError
        errors.reject("user.properties.not.null");
        errors.rejectValue("name", "name.required");

        // 3、获取 Errors 中的 ObjectError 和 FieldError
        // FieldError is ObjectError
        List<ObjectError> globalErrors = errors.getGlobalErrors();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        List<ObjectError> allErrors = errors.getAllErrors();

        // 4、通过 ObjectError 和 FieldError 中的 code 和 args 来关联 MessageSource 实现
        MessageSource messageSource = createMessageSource();
        allErrors.forEach(error -> {
            String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println(message);
        });
    }

    static MessageSource createMessageSource() {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("user.properties.not.null", Locale.getDefault(), "user的所有属性不能为空");
        messageSource.addMessage("id.required", Locale.getDefault(), "The id of user must not be null");
        messageSource.addMessage("name.required", Locale.getDefault(), "The name of user must be not null");
        return messageSource;
    }
}
