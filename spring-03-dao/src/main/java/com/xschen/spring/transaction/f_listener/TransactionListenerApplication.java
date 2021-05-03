package com.xschen.spring.transaction.f_listener;

import com.xschen.spring.transaction.f_listener.configuration.TransactionListenerConfiguration;
import com.xschen.spring.transaction.f_listener.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class TransactionListenerApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TransactionListenerConfiguration.class);
        UserService userService = context.getBean(UserService.class);
        userService.saveUser();
    }
}
