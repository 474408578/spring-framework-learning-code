package com.xschen.spring.transaction;

import com.xschen.spring.transaction.config.TransactionAspectConfiguration;
import com.xschen.spring.transaction.service.FinanceService;
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
