package com.think.in.spring.aop.feature.interceptor;

import com.think.in.spring.aop.overview.EchoService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;

import java.lang.reflect.Method;

/**
 * {@link EchoService} 方法拦截器示例
 * @author xschen
 * @date 2021/9/20 17:57
 *
 * @see ProxyFactoryBean#setInterceptorNames(String...)
 * @see MethodInterceptor
 * @see AbstractAutoProxyCreator#setInterceptorNames(String...)
 */

public class EchoServiceMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        System.out.println("拦截EchoService的方法：" + method);
        return invocation.proceed(); // 执行目标方法
    }
}
