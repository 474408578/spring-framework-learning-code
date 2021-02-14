package com.xschen.spring.transaction.e_spread;

import com.xschen.spring.transaction.e_spread.config.TransactionSpreadConfiguration;
import com.xschen.spring.transaction.e_spread.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 感知事务状态
 * @author xschen
 */

public class TransactionSpreadSourceApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TransactionSpreadConfiguration.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.register();
    }
}
