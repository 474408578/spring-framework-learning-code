package com.xschen.spring.mybatis.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Function;

/**
 * @author xschen
 */


public class DaoUtils {
    private static SqlSessionFactory factory;

    // 在静态代码块中直接读取mybatis-config配置文件
    static {
        String configLocation = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(configLocation);
        } catch (IOException e) {
            System.err.println("read mybatis-config.xml fail");
            e.printStackTrace();
            System.exit(1);
        }
        // 加载mybatis-config.xml配置文件，并创建SqlSessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static <R> R execute(Function<SqlSession, R> function) {
        // 创建SqlSession
        SqlSession session = factory.openSession();
        try {
            R apply = function.apply(session);
            // 提交事务
            session.commit();
            return apply;
        } catch (Throwable t) {
            // 出现异常的时候，回滚事务
            session.rollback();
            System.out.println("execute error");
            throw t;
        } finally {
            // 关闭SqlSession
            session.close();
        }
    }
}
