package com.xschen.spring.aop.a_xmlaspect;

import com.xschen.spring.aop.a_xmlaspect.service.FinanceService;
import com.xschen.spring.aop.a_xmlaspect.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * xml aspect 示例, 需要在pom.xml中引入 aspectjweaver
 * @author xschen
 */


public class XmlAspectApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("xmlaspect.xml");

        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.addMoney(123.45);
        financeService.subtractMoney(543.21);
        financeService.getMoneyById("abc");

        OrderService orderService = ctx.getBean(OrderService.class);
        orderService.createOrder();
        orderService.getOrderById("abcde");
    }
}
