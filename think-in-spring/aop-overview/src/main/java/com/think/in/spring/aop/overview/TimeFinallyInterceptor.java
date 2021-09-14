package com.think.in.spring.aop.overview;

import java.lang.reflect.Method;

/**
 * @author xschen
 * @date 2021/9/14 13:07
 */
public class TimeFinallyInterceptor implements FinallyInterceptor {
    private final Long startTime;
    private final Long endTime;

    public TimeFinallyInterceptor(Long startTime, Long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public Object finalize(Object proxy, Method method, Object[] args, Object returnResult) {
        // 方法执行时间（毫秒）
        return endTime - startTime;
    }
}
