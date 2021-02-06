package com.xschen.spring.aop.b_aspectj.service;

import com.xschen.spring.aop.b_aspectj.component.Log;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
public class FinanceService {

    public void addMoney(double money) {
        System.out.println("FinanceService 收钱 === " + money);
    }

    public double subtractMoney(double money) {
        System.out.println("FinanceService 付钱 === " + money);
        return money;
    }

    @Log // 除了 execution 之外， 还有一种切入表达式也比较常用，@annotation
    public double subtractMoney(double money, String id) {
        System.out.println("FinanceService 付钱 === " + money);
        return money;
    }

    public double getMoneyById(String id) {
        System.out.println("FinanceService 查询账户，id为" + id);
        return Math.random();
    }

}
