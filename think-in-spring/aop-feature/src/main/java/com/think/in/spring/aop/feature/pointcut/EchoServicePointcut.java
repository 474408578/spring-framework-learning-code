package com.think.in.spring.aop.feature.pointcut;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author xschen
 * @date 2021/9/20 21:13
 */

public class EchoServicePointcut extends StaticMethodMatcherPointcut {
    private String methodName;
    private Class targetClass;

    public EchoServicePointcut(String methodName, Class targetClass) {
        this.methodName = methodName;
        this.targetClass = targetClass;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return Objects.equals(methodName, method.getName()) &&
                this.targetClass.isAssignableFrom(targetClass);
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }
}
