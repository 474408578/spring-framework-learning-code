package com.think.in.spring.aop.overview;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * Aop 目标过滤示例
 * @author xschen
 * @date 2021/9/13 21:29
 */

public class TargetFilterDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        String targetClassName = "com.think.in.spring.aop.overview.EchoService";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class targetClass = classLoader.loadClass(targetClassName);
        // 获取方法定义
        Method method = ReflectionUtils.findMethod(targetClass, "echo", String.class);
        System.out.println(method);

        // 查找方法 throws 类型为 NullPointException
        // Spring 反射工具类
        ReflectionUtils.doWithMethods(targetClass, new ReflectionUtils.MethodCallback() {
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                System.out.println("仅抛出 NullPointException 的方法为：" + method);
            }
        }, new ReflectionUtils.MethodFilter() {
            @Override
            public boolean matches(Method method) {
                Class[] parameterTypes = method.getParameterTypes();
                Class[] exceptionTypes = method.getExceptionTypes();
                return parameterTypes.length == 1 &&
                        String.class.equals(parameterTypes[0]) &&
                        exceptionTypes.length == 1 &&
                        NullPointerException.class.equals(exceptionTypes[0]);
            }
        });
    }
}
