package com.xschen.spring.transation.aspect;

import com.xschen.spring.transation.utils.JdbcUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.Connection;

/**
 * 事务切面类
 * @author xschen
 */

@Aspect
@Component
public class TransactionAspect {

    @Around("@annotation(com.xschen.spring.transation.aspect.Transactional)")
    public Object doWithTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        Connection connection = JdbcUtils.getConnection();
        // 开启事务
        connection.setAutoCommit(false);
        try {
            Object retVal = joinPoint.proceed();
            // 方法执行成功，提交事务
            connection.commit();
            return retVal;
        } catch (Throwable e) {
            // 方法执行异常，回滚事务
            connection.rollback();
            throw e;
        } finally {
            JdbcUtils.remove();
        }
    }
}
