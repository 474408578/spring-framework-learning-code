package com.xschen.spring.aop.f_introduction;

import com.xschen.spring.aop.f_introduction.configuration.IntroductionConfiguration;
import com.xschen.spring.aop.f_introduction.service.FinanceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Aspectj 引介示例: 给目标对象所在的类，动态的添加属性和方法
 * @author xschen
 */

public class IntroductionApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(IntroductionConfiguration.class);
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.transfer(1L, 2L, 100);

    }
}
