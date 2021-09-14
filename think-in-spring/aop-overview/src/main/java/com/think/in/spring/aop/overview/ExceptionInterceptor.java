package com.think.in.spring.aop.overview;

import java.lang.reflect.Method;

/**
 * 异常拦截器
 * @author xschen
 * @date 2021/9/14 12:41
 */

public interface ExceptionInterceptor {

    /**
     * @param proxy
     * @param method
     * @param args
     * @param throwable 异常
     */
    void interceptor(Object proxy, Method method, Object[] args, Throwable throwable);
}
