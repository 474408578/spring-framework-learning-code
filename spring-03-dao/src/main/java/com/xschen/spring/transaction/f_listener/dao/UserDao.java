package com.xschen.spring.transaction.f_listener.dao;

import com.xschen.spring.transaction.f_listener.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xschen
 */

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveUser(User user) {
        jdbcTemplate.update("insert into tbl_user (name, tel) values (?, ?)", user.getName(), user.getTel());
    }

    public List<User> findAll() {
        List<User> users = jdbcTemplate.query("select * from tbl_user",
                new BeanPropertyRowMapper<>(User.class));
        return users;
    }
}
