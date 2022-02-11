package com.think.in.spring.validation.rawvalidation;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;

import static com.think.in.spring.validation.rawvalidation.ValidatorUtil.obtainExecutableValidator;

/**
 * Validator Demo
 * @author xschen
 * @date 2022/2/10 9:54
 * @see Valid
 */
public class ValidatorDemo implements PersonService {

    private Integer version;

    // 方法参数级联检验
    @Override
    public void save(Person person) throws NoSuchMethodException {
        Method currMethod = this.getClass().getMethod("save", Person.class);
        Set<ConstraintViolation<ValidatorDemo>> violations = obtainExecutableValidator().validateParameters(this, currMethod, new Object[]{person});
        if (!violations.isEmpty()) {
            // ... 输出错误详情violations
            ValidatorUtil.printViolations(violations);
        }
    }
    // 构造器参数校验
    public ValidatorDemo(@NotNull @Min(2) Integer version) throws NoSuchMethodException {
        this.version = version;
        Constructor<ValidatorDemo> currMethod = (Constructor<ValidatorDemo>) this.getClass().getConstructor(Integer.class);
        Set<ConstraintViolation<ValidatorDemo>> violations = obtainExecutableValidator()
                .validateConstructorParameters(currMethod, new Object[]{version});
        if (!violations.isEmpty()) {
            ValidatorUtil.printViolations(violations);
        }
    }

    // 方法返回值参数校验
    @Override
    public Person getOne(Integer id) throws NoSuchMethodException {
        // 问题： 代码侵入性强： 使用AOP解决-->
        Method currMethod = this.getClass().getMethod("getOne", Integer.class);
        // 模拟逻辑执行，得到一个result
        Person person = null;
        // 在返回之前校验
        Set<ConstraintViolation<ValidatorDemo>> violations = obtainExecutableValidator().validateReturnValue(this, currMethod, person);
        if (!violations.isEmpty()) {
            ValidatorUtil.printViolations(violations);
        }
        return person;
    }


    public static void main(String[] args) throws NoSuchMethodException {

        PersonService personService = new ValidatorDemo(0);

        Person person = new Person();
        person.setAge(123);
        personService.save(null);
        // valid 级联验证
        personService.save(person);

        personService.getOne(0);
    }
}
