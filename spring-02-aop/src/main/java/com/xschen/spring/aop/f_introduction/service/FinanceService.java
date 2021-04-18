package com.xschen.spring.aop.f_introduction.service;

import org.springframework.stereotype.Service;

/**
 * @author xschen
 */

@Service
public class FinanceService {

    public void transfer(long source, long target, int money) {
        System.out.println("转账完成！");
        System.out.println(source + " 为 " + target + " 转钱" + money + "元！");
    }
}
