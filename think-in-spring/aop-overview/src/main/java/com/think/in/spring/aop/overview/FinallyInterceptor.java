package com.think.in.spring.aop.overview;

import java.lang.reflect.Method;

/**
 * 最终执行后置拦截器
 * @author xschen
 * @date 2021/9/14 12:57
 */

public interface FinallyInterceptor {

    /**
     * 最终执行
     * @param proxy
     * @param method
     * @param args
     * @param returnResult 执行方法返回结果
     * @return
     */
    Object finalize(Object proxy, Method method, Object[] args, Object returnResult);
}
