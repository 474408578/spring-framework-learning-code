package com.xschen.spring.transaction.e_spread;

import com.xschen.spring.transaction.e_spread.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * 事务的传播特性（事务的嵌套）
 * @author xschen
 */
public class TransactionSpreadApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("tx/transaction-spread.xml");
        UserService userService = ctx.getBean(UserService.class);
        userService.register();

    }
}
