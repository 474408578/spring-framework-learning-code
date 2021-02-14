package com.xschen.spring.transaction.d_declarativeannotation.service;

import com.xschen.spring.transaction.d_declarativeannotation.bean.User;
import com.xschen.spring.transaction.d_declarativeannotation.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xschen
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void saveAndQuery() {
        User user = new User();
        user.setName("ddd");
        user.setTel("123456");
        userDao.saveUser(user);

        int i = 1 /0;

        List<User> users = userDao.findAll();
        System.out.println(users);
    }
}
