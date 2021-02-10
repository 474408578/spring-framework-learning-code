package com.xschen.spring.jdbc.c_dao;

import com.xschen.spring.jdbc.c_dao.config.JdbcConfiguration;
import com.xschen.spring.jdbc.c_dao.dao.UserDao;
import com.xschen.spring.jdbc.c_dao.dao.UserDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class JdbcTemplateDaoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcConfiguration.class);
        UserDao userDao = ctx.getBean(UserDaoImpl.class);
        userDao.findAll().forEach(System.out::println);
    }
}
