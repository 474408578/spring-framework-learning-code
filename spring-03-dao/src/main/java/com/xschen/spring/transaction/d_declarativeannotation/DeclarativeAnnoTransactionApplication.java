package com.xschen.spring.transaction.d_declarativeannotation;

import com.xschen.spring.transaction.d_declarativeannotation.config.DeclarativeTransactionConfiguration;
import com.xschen.spring.transaction.d_declarativeannotation.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */
public class DeclarativeAnnoTransactionApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DeclarativeTransactionConfiguration.class);

        UserService userService = ctx.getBean(UserService.class);
        userService.saveAndQuery();
    }
}
