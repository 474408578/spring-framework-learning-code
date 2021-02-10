package com.xschen.spring.transaction.b_programmatic.service;

import com.xschen.spring.transaction.b_programmatic.bean.User;
import com.xschen.spring.transaction.b_programmatic.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * @author xschen
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TransactionTemplate transactionTemplate;


    public void saveAndQuery() {
        User user = new User();
        user.setName("bbb");
        user.setTel("123456");

//        userDao.save(user);
//
//        int i = 1 / 0;
//        List<User> users = userDao.findAll();
//        System.out.println(users);

//        transactionTemplate.execute(status -> {
//            userDao.save(user);
//
//            int i = 1 / 0;
//
//            List<User> users = userDao.findAll();
//            System.out.println(users);
//            return null;
//        });

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                userDao.save(user);

                int i = 1 / 0;

                List<User> users = userDao.findAll();
                System.out.println(users);
            }
        });
    }
}
