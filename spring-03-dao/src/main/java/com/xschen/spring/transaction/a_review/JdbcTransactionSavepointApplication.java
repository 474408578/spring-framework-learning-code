package com.xschen.spring.transaction.a_review;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * Jdbc事务保存点 示例
 * @author xschen
 *
 * @see Savepoint
 */


public class JdbcTransactionSavepointApplication {

    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc/spring-jdbc.xml");
        DataSource dataSource = ctx.getBean(DataSource.class);
        Connection connection = null;
        Savepoint savepoint = null; // 事务保存点
        try {
            connection  = dataSource.getConnection();
            // 开启事务
            connection.setAutoCommit(false);
            PreparedStatement statement = connection
                    .prepareStatement("insert into tbl_user (name, tel) values('xiangsong', 123456)");
            statement.executeUpdate();

            // 设置事务保存点
            savepoint = connection.setSavepoint();

            statement =  connection.prepareStatement("insert into tbl_account (user_id, money) values (2, 123)");
            statement.executeUpdate();

            // 抛出异常
            int i = 1/ 0;
            statement = connection.prepareStatement("delete from tbl_user where id = 1");
            statement.executeUpdate();

            // 提交事务
            connection.commit();
        } catch (Exception e) {
            // 回滚事务
            // 此时事务还是存在的，还需要手动提交一次，不然保存点之前的SQL语句是不会生效的
            if (savepoint != null) {
                connection.rollback(savepoint);
                connection.commit();
            } else {
                connection.rollback();
            }
        } finally {
            // 关闭连接
            if (connection != null) {
                connection.close();
            }
        }
    }
}