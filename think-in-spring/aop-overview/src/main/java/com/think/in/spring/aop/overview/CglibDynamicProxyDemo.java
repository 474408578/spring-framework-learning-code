package com.think.in.spring.aop.overview;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB 动态代理 示例
 * @author xschen
 * @date 2021/9/14 15:43
 */

public class CglibDynamicProxyDemo {

    public static void main(String[] args) throws Throwable {
        Enhancer enhancer = new Enhancer();
        Class supperClass = DefaultEchoService.class;
        enhancer.setSuperclass(supperClass);
        // 指定拦截接口
        enhancer.setInterfaces(new Class[] {EchoService.class});
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * @param source
             * @param method 代理对象的方法
             * @param args
             * @param methodProxy 目标对象的方法
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object source, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                long startTime = System.currentTimeMillis();
                // Source -> CGLIB 子类
                // 目标类 -> DefaultEchoService
                // 错误使用
                // Object result = method.invoke(source, args);
                // 正确的方法调用
                Object result = methodProxy.invokeSuper(source, args);
                long costTime = System.currentTimeMillis() - startTime;
                System.out.println(result);
                System.out.println("[CGLIB 字节码提升] echo 方法执行的实现：" + costTime + " ms.");
                return result;
            }
        });

        // 创建代理对象
        EchoService echoService = (EchoService) enhancer.create();
        echoService.echo("Hello, World");
    }
}
