package com.xschen.spring.transaction.service;

import com.xschen.spring.transaction.aspect.Transactional;
import com.xschen.spring.transaction.dao.FinanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xschen
 */


@Service
public class FinanceService {

    @Autowired
    private FinanceDao financeDao;

    @Transactional
    public void transfer(Long source, Long target, int money) {
        financeDao.subtract(source, money);
        int i = 1 / 0;
        financeDao.addMoney(target, money);
    }
}
