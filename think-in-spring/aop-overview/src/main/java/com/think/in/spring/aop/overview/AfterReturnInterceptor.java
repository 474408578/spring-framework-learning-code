package com.think.in.spring.aop.overview;

import java.lang.reflect.Method;

/**
 * (方法返回）后置拦截器
 * @author xschen
 * @date 2021/9/14 12:36
 */
public interface AfterReturnInterceptor {
    /**
     * 返回后的后置执行
     * @param proxy
     * @param method
     * @param args
     * @param returnResult 执行方法的返回结果
     * @return
     */
    Object afterReturn(Object proxy, Method method, Object[] args, Object returnResult);
}
