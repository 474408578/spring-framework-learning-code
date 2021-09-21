package com.think.in.spring.aop.feature;

import com.think.in.spring.aop.feature.aspect.AspectConfiguration;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 编程方式创建@AspectJ代理
 * @author xschen
 * @date 2021/9/20 12:16
 * @see AspectJProxyFactory
 */


public class AspectJAnnotationUsingApiDemo {

    public static void main(String[] args) {
        Map<String, Object> cache = new HashMap<>();
        AspectJProxyFactory factory = new AspectJProxyFactory(cache);

        // 增加 Aspect 配置类
        factory.addAspect(AspectConfiguration.class);
        factory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                if ("put".equals(method.getName()) && args.length == 2) {
                    System.out.printf("[MethodBeforeAdvice] currentKey: %s , newValue: %s, oldValue: %s \n", args[0], args[1]);
                }
            }
        });

        factory.addAdvice(new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                if ("put".equals(method.getName()) && args.length == 2) {
                    System.out.printf("[AfterReturningAdvice] currentKey: %s , newValue : %s, oldValue： %s\n",
                            args[0], args[1], returnValue);
                }
            }
        });

        Map<String, Object> proxy = factory.getProxy();
        // 通过代理对象存储数据
        proxy.put("1", "A");
        proxy.put("1", "B");
        System.out.println(proxy.get("1"));
    }
}
