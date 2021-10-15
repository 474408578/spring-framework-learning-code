package com.xschen.spring.analysis.springutils;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * ReflectionUtils 示例
 * @author xschen
 * @date 2021/9/26 11:57
 * @see ReflectionUtils#doWithLocalMethods(Class, ReflectionUtils.MethodCallback)
 *
 */
public class ReflectionUtilsDemo {

    public static void main(String[] args) {
        List<Method> methods = new ArrayList<>();
        // 函数式编程传递, Lambda
        ReflectionUtils.doWithLocalMethods(Person.class, method -> {
            methods.add(method);
        });

        // 匿名内部类
//        ReflectionUtils.doWithLocalMethods(Person.class, new ReflectionUtils.MethodCallback() {
//            @Override
//            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
//                methods.add(method);
//            }
//        });

        methods.stream().forEach(System.out::println); // public void com.xschen.spring.analysis.springutils.ReflectionUtilsDemo$Person.sayHello()
    }

    static class Person {
        private String name;
        public void sayHello() {
            System.out.println(name + " Say Hello.");
        }
    }
}
