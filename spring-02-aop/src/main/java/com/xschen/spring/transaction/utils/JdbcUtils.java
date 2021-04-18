package com.xschen.spring.transaction.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author xschen
 */


public class JdbcUtils {

    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    // 需要在服务端执行 grant all privileges on *.* to root@'%' identified by "123456";
    public static final String JDBC_URL = "jdbc:mysql://119.45.56.227:3306/testdb?characterEncoding=utf-8";

    public static Connection getConnection() {
        // threadLocal有，直接取出
        if (connectionThreadLocal.get() != null) {
            return connectionThreadLocal.get();
        }

        // 没有，则创建
        return openConnection();
    }

    public static Connection openConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(JDBC_URL,"root", "123456");
            connectionThreadLocal.set(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public static void remove() {
        connectionThreadLocal.remove();
    }

}
