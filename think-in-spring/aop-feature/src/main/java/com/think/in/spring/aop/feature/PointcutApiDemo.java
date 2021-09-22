package com.think.in.spring.aop.feature;

import com.think.in.spring.aop.feature.interceptor.EchoServiceMethodInterceptor;
import com.think.in.spring.aop.feature.pointcut.EchoServiceEchoMethodPointcut;
import com.think.in.spring.aop.feature.pointcut.EchoServicePointcut;
import com.think.in.spring.aop.overview.DefaultEchoService;
import com.think.in.spring.aop.overview.EchoService;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Api 实现 Pointcut 示例
 * @author xschen
 * @date 2021/9/20 21:18
 * @see Pointcut
 * @see ClassFilter
 * @see MethodMatcher
 * @see DefaultPointcutAdvisor 适配实现
 */

public class PointcutApiDemo {

    public static void main(String[] args) throws Throwable {

        // 方案1：使用 EchoServicePointcut
        //EchoServicePointcut echoServicePointcut = new EchoServicePointcut("echo", EchoService.class);

        // 方案2：使用 EchoServiceEchoMethodPointcut
        EchoServiceEchoMethodPointcut echoServicePointcut = EchoServiceEchoMethodPointcut.INSTANCE;

        EchoService defaultEchoService = new DefaultEchoService();
        // 将 Pointcut 适配成 advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(echoServicePointcut, new EchoServiceMethodInterceptor());

        ProxyFactory proxyFactory = new ProxyFactory(defaultEchoService);
        // 添加 advisor
        proxyFactory.addAdvisor(advisor);
        // 获取代理对象
        EchoService echoService = (EchoService) proxyFactory.getProxy();
        System.out.println(echoService.echo("Hello World"));
    }
}
