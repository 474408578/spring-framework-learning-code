package com.think.in.spring.aop.overview;

/**
 * 类加载示例
 * @author xschen
 * @date 2021/9/13 18:00
 */

public class ClassLoadingDemo {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        ClassLoader parentClassLoader = classLoader.getParent();

        while (true) {
            System.out.println(parentClassLoader);
            if (parentClassLoader.getParent() == null) { // Bootstrap ClassLoader
                break;
            }
            parentClassLoader = parentClassLoader.getParent();
        }
    }
}
