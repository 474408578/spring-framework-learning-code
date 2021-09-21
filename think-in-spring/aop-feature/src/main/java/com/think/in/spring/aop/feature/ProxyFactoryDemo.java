package com.think.in.spring.aop.feature;

import com.think.in.spring.aop.feature.interceptor.EchoServiceMethodInterceptor;
import com.think.in.spring.aop.overview.DefaultEchoService;
import com.think.in.spring.aop.overview.EchoService;
import org.springframework.aop.framework.ProxyFactory;

/**
 * {@link ProxyFactory} 示例
 * @author xschen
 * @date 2021/9/20 18:13
 * @see ProxyFactory
 */

public class ProxyFactoryDemo {

    public static void main(String[] args) throws Throwable {
        DefaultEchoService defaultEchoService = new DefaultEchoService();
        // 注入目标对象（被代理对象）
        ProxyFactory proxyFactory = new ProxyFactory(defaultEchoService);
        // 添加 Advice 实现 MethodInterceptor < Interceptor < Advice
        proxyFactory.addAdvice(new EchoServiceMethodInterceptor());
        // 获取代理对象
        EchoService echoServiceProxy = (EchoService) proxyFactory.getProxy();
        System.out.println(echoServiceProxy.echo("Hello World"));
    }
}
