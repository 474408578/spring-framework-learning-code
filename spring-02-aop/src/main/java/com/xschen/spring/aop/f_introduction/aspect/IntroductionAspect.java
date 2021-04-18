package com.xschen.spring.aop.f_introduction.aspect;

import com.xschen.spring.aop.f_introduction.validator.MoneyValidator;
import com.xschen.spring.aop.f_introduction.validator.MoneyValidatorImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
@Aspect
public class IntroductionAspect {

    @DeclareParents(value = "com.xschen.spring.aop.f_introduction.service.FinanceService", defaultImpl = MoneyValidatorImpl.class)
    private MoneyValidator moneyValidator;

    @Before("execution(* com.xschen.spring.aop.f_introduction.service.FinanceService.transfer(long,long,int))")
    public void beforePrintLog(JoinPoint joinPoint) {
        int money = (int) joinPoint.getArgs()[2];
        MoneyValidator validator = (MoneyValidator) joinPoint.getThis();
        if (validator.validate(money)) {
            System.out.println("转账动作前置打印 。。。");
        } else {
            throw new IllegalArgumentException("转账金额不合法！");
        }

    }

}
