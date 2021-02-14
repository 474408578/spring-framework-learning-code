package com.xschen.spring.transaction.c_declarativexml.service;

import com.xschen.spring.transaction.c_declarativexml.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xschen
 */


@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public void transfer(Integer sourceId, Integer targetId, int money) {
        accountDao.subtractMoney(sourceId, money);

        int i = 1 / 0;

        accountDao.addMoney(targetId, money);
    }
}
