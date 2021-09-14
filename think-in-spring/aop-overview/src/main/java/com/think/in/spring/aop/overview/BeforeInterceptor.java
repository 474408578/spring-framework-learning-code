package com.think.in.spring.aop.overview;

import java.lang.reflect.Method;

/**
 * 前置拦截器
 * @author xschen
 * @date 2021/9/14 12:28
 */

public interface BeforeInterceptor {

    /**
     * 前置执行
     * @param proxy
     * @param method
     * @param args
     * @return
     */
    Object before(Object proxy, Method method, Object[] args);
}
