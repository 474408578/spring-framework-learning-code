package com.xschen.spring.jdbc.c_dao.dao;

import com.xschen.spring.jdbc.c_dao.bean.User;

import java.util.List;

/**
 * @author xschen
 */


public interface UserDao {
    void save(User user);
    User findById(Integer id);
    List<User> findAll();
}
