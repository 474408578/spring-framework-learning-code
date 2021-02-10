package com.xschen.spring.transaction.b_programmatic;

import com.xschen.spring.transaction.b_programmatic.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xschen
 */


public class ProgrammaticTransactionApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("tx/programmatic-transaction.xml");
        UserService userService = ctx.getBean(UserService.class);
        userService.saveAndQuery();
    }
}
