package com.think.in.spring.aop.feature.pointcut;

import com.think.in.spring.aop.overview.EchoService;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author xschen
 * @date 2021/9/22 22:15
 * @see ClassFilter 类过滤器
 * @see MethodMatcher 方法匹配器
 */

public class EchoServiceEchoMethodPointcut implements Pointcut {

    public static final EchoServiceEchoMethodPointcut INSTANCE = new EchoServiceEchoMethodPointcut();

    private EchoServiceEchoMethodPointcut() {}

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                return EchoService.class.isAssignableFrom(clazz);
            }
        };
    }

    //@Override // 方案1 : 执行 matches(Method, Class<?>, args[])
    //public MethodMatcher getMethodMatcher() {
    //    return new MethodMatcher() {
    //        @Override
    //        public boolean matches(Method method, Class<?> targetClass) {
    //            return true;
    //        }
    //
    //        @Override
    //        public boolean isRuntime() {
    //            return false;
    //        }
    //
    //        /**
    //         * 当 isRuntime() == true && MethodMatcher#(Method, Class<?>) == true 时，
    //         * 此方法才会被调用.
    //         * @param method
    //         * @param targetClass
    //         * @param args
    //         * @return
    //         */
    //        @Override
    //        public boolean matches(Method method, Class<?> targetClass, Object... args) {
    //            return "echo".equals(method.getName()) &&
    //                    args.length == 1 &&
    //                    Objects.equals(String.class, args[0].getClass());
    //        }
    //    };
    //}


    @Override // 方案2：执行 MethodMatcher#(Method, Class<?>)
    public MethodMatcher getMethodMatcher() {
        return new MethodMatcher() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                return "echo".equals(method.getName()) &&
                        method.getParameterCount() == 1 &&
                        Objects.equals(String.class, method.getParameterTypes()[0]);
            }

            @Override
            public boolean isRuntime() {
                return false;
            }

            @Override
            public boolean matches(Method method, Class<?> targetClass, Object... args) {
                return false;
            }
        };
    }
}
