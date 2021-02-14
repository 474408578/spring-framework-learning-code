package com.xschen.spring.transaction.c_declarativexml.service;

import com.xschen.spring.transaction.c_declarativexml.bean.User;
import com.xschen.spring.transaction.c_declarativexml.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xschen
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void saveAndQuery() {
        User user = new User();
        user.setName("ccc");
        user.setTel("123456");
        userDao.saveUser(user);

//        int i = 1 /0;

        List<User> users = userDao.findAll();
        System.out.println(users);
    }
}
