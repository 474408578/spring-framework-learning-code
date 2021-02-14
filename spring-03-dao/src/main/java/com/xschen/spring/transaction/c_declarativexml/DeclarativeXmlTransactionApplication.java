package com.xschen.spring.transaction.c_declarativexml;

import com.xschen.spring.transaction.c_declarativexml.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于xml的声明式事务控制
 * @author xschen
 */
public class DeclarativeXmlTransactionApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("tx/declarative-transaction.xml");
        UserService userService = ctx.getBean(UserService.class);
        userService.saveAndQuery();
    }
}
