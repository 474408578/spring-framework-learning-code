package com.xschen.spring.transation.dao;

import com.xschen.spring.transation.utils.JdbcUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author xschen
 */

@Repository
public class FinanceDao {

    public void addMoney(Long id, int money) {
        try {
            Connection connection = JdbcUtils.getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update tbl_employee set salary = salary + ? where id = ?");
            preparedStatement.setInt(1, money);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void subtract(Long id, int money) {
        try {
            Connection connection = JdbcUtils.getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update tbl_employee set salary = salary - ? where id = ?");
            preparedStatement.setInt(1, money);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
