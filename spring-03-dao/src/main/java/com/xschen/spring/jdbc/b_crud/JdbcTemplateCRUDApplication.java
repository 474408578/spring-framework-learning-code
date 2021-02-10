package com.xschen.spring.jdbc.b_crud;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author xschen
 */


public class JdbcTemplateCRUDApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc/spring-jdbc.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

        // 插入数据
//        int row = jdbcTemplate.update("insert into tbl_user (name, tel) values (?, ?)", "heihei", "200");

        // 修改数据
//        int row = jdbcTemplate.update("update tbl_user set tel = ? where name = ?", "54321", "heihei");
        // 删除数据
        int row = jdbcTemplate.update("delete from tbl_user where name = ?", "heihei");
//        System.out.println(row);

        // 查全表
//        List<User> users = jdbcTemplate.query("select * from tbl_user", new BeanPropertyRowMapper<>(User.class));
//        List<User> users = jdbcTemplate.query("select * from tbl_user where id > ?", new BeanPropertyRowMapper<>(User.class), 2);
//        users.forEach(System.out::println);


        // 查单个
//        List<User> users = jdbcTemplate.query("select * from tbl_user where id = ?", new BeanPropertyRowMapper<>(User.class), 2);
//        System.out.println(users);

        Long count = jdbcTemplate.queryForObject("select count(id) from tbl_user", Long.class);
        System.out.println(count);
    }

}
