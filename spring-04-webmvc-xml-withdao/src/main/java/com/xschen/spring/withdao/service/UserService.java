package com.xschen.spring.withdao.service;

import com.xschen.spring.withdao.dao.UserDao;
import com.xschen.spring.withdao.entity.User;
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

    public void update(User user) {
        userDao.update(user);
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public User findById(String id) {
        return userDao.findById(id);
    }
}
