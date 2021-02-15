package com.xschen.spring.jdbc.d_queryfor;

import com.xschen.spring.jdbc.c_dao.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xschen
 *
 * @see NamedParameterJdbcTemplate
 */
public class JdbcTemplateQueryApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc/spring-jdbc.xml");
//        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

        // 这样写不行，会抛出异常  Incorrect column count: expected 1, actual 3
//        List<User> users = jdbcTemplate.queryForList("select * from tbl_user", User.class);

        // 只查询 name字段
//        List<String> userNames = jdbcTemplate.queryForList("select name from tbl_user", String.class);
//        userNames.forEach(System.out::println);

//        List<Map<String, Object>> users = jdbcTemplate.queryForList("select * from tbl_user where id > ?", 3);
//        users.forEach(System.out::println);


        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(ctx.getBean(DataSource.class));
        Map<String, Object> params = new HashMap<>();
        params.put("id", 3);
        params.put("name", "ha%");
        List<Map<String, Object>> users = jdbcTemplate
                .queryForList("select * from tbl_user where id > :id and name like :name", params);
        users.forEach(System.out::println);


    }
}
