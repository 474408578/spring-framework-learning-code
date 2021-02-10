package com.xschen.spring.transaction.a_review;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Jdbc事务示例
 * @author xschen
 */


public class JdbcTransactionApplication {

    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc/spring-jdbc.xml");
        DataSource dataSource = ctx.getBean(DataSource.class);
        Connection connection = null;
        try {
            connection  = dataSource.getConnection();
            // 开启事务
            connection.setAutoCommit(false);
            PreparedStatement statement = connection
                    .prepareStatement("insert into tbl_user (name, tel) values('hahaha', 123456)");
            statement.executeUpdate();

            // 抛出异常
            int i = 1/ 0;
            statement = connection.prepareStatement("delete from tbl_user where id = 1");
            statement.executeUpdate();

            // 提交事务
            connection.commit();
        } catch (Exception e) {
            // 回滚事务
            connection.rollback();
        } finally {
            // 关闭连接
            if (connection != null) {
                connection.close();
            }
        }
    }
}