package com.think.in.spring.aop.overview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * AOP 拦截示例
 * @author xschen
 * @date 2021/9/14 12:25
 */

public class AopInterceptorDemo {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        /**
         * classLoader: 目标对象所属类的类加载器
         * interfaces: 目标对象所属类实现的接口
         * invocationHandler：代理的具体代码实现
         */
        Object proxy = Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
                    // 前置拦截器
                    BeforeInterceptor beforeInterceptor = new BeforeInterceptor() {

                        @Override
                        public Object before(Object proxy, Method method, Object[] args) {
                            return System.currentTimeMillis();
                        }
                    };

                    Long startTime = 0L;
                    Long endTime = 0L;
                    Object result = null;
                    try {
                        // 前置拦截
                        startTime = (Long) beforeInterceptor.before(proxy, method, args);
                        EchoService echoService = new DefaultEchoService();
                        // 目标对象执行
                        result = echoService.echo((String) args[0]);
                        // 后置拦截器
                        AfterReturnInterceptor afterReturnInterceptor = new AfterReturnInterceptor() {
                            @Override
                            public Object afterReturn(Object proxy, Method method, Object[] args, Object returnResult) {
                                return System.currentTimeMillis();
                            }
                        };
                        // 后置拦截
                        endTime = (Long) afterReturnInterceptor.afterReturn(proxy,method,args,result);
                    } catch (Exception e) {
                        //
                        ExceptionInterceptor exceptionInterceptor = (proxy1, method1, args1, throwable) -> {
                            // 具体要拦截的逻辑
                        };
                    } finally {
                        // 最终拦截
                        FinallyInterceptor finallyInterceptor = new TimeFinallyInterceptor(startTime, endTime);
                        Long costTime = (Long) finallyInterceptor.finalize(proxy, method, args, result);
                        System.out.println(result);
                        System.out.println("echo 方法执行的实现：" + costTime + " ms.");
                    }
                    return result;
                }
                return null;
            }
        });

        EchoService echoService = (EchoService) proxy;
        echoService.echo("Hello, World");
    }
}
