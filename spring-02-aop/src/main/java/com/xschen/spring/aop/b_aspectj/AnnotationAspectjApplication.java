package com.xschen.spring.aop.b_aspectj;

import com.xschen.spring.aop.b_aspectj.config.AspectjAopConfiguration;
import com.xschen.spring.aop.b_aspectj.service.FinanceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class AnnotationAspectjApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AspectjAopConfiguration.class);

        ctx.refresh();
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.addMoney(123.45);
        financeService.subtractMoney(54.123);
        financeService.getMoneyById("abc");

        financeService.subtractMoney(123.123, "abc");
    }
}
