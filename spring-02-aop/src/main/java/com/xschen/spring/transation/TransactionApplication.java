package com.xschen.spring.transation;

import com.xschen.spring.transation.config.TransactionAspectConfiguration;
import com.xschen.spring.transation.service.FinanceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class TransactionApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TransactionAspectConfiguration.class);
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.transfer(1L, 2L, 100);

    }
}
