package com.xschen.spring.transaction.b_programmatic.dao;

import com.xschen.spring.transaction.b_programmatic.bean.User;
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

    public void save(User user) {
        jdbcTemplate.update("insert into tbl_user (name, tel) values (?, ?)", user.getName(), user.getTel());
    }

    public User findById(Integer id) {
        List<User> users = jdbcTemplate.query("select * from tbl_user where id = ?",
                new BeanPropertyRowMapper<>(User.class),
                id);

        return users.size() > 0 ? users.get(0) : null;
    }

    public List<User> findAll() {
        return jdbcTemplate.query("select * from tbl_user", new BeanPropertyRowMapper<>(User.class));
    }
}
