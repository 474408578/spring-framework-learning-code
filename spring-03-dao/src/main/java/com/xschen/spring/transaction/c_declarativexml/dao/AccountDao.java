package com.xschen.spring.transaction.c_declarativexml.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author xschen
 */

@Repository
public class AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addMoney(Integer userId, int money) {
        jdbcTemplate.update("update tbl_account money = money + ? where user_id = ?", money, userId);
    }

    public void subtractMoney(Integer userId, int money) {
        jdbcTemplate.update("update tbl_account money = money - ? where user_id = ?", money, userId);
    }
}
