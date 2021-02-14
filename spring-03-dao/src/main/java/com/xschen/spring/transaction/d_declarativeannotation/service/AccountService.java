package com.xschen.spring.transaction.d_declarativeannotation.service;

import com.xschen.spring.transaction.d_declarativeannotation.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xschen
 */


@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public void transfer(Integer sourceId, Integer targetId, int money) {
        accountDao.subtractMoney(sourceId, money);

        int i = 1 / 0;

        accountDao.addMoney(targetId, money);
    }
}
