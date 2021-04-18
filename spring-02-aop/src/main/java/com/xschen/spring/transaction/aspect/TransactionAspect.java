package com.xschen.spring.transaction.aspect;

import com.xschen.spring.transaction.utils.JdbcUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.Connection;

/**
 * 事务切面类, 实现事务控制
 * @author xschen
 */

@Aspect
@Component
public class TransactionAspect {

    /**
     * 基于注解的切入点表达式
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("@annotation(com.xschen.spring.transaction.aspect.Transactional)")
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
