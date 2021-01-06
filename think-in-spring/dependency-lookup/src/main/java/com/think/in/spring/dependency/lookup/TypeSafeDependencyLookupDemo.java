package com.think.in.spring.dependency.lookup;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 安全查找示例
 *
 * @author xschen
 */


public class TypeSafeDependencyLookupDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TypeSafeDependencyLookupDemo.class);

        applicationContext.refresh();

        // 演示BeanFactory#getBean()方法的安全性
        displayBeanFactoryGetBean(applicationContext);

        // 演示ObjectFactory#getObject()方法的安全性
        displayObjectFactoryGetObject(applicationContext);

        // 演示ObjectProvider#getIfAvaiable()方法的安全性
        displayObjectProviderGetIfAvaiable(applicationContext);

        // 演示ListableBeanFactory#getBeansOfType()方法的安全性
        displayListableBeanFactoryGetBeansOfType(applicationContext);

        // 演示ObjectProvider Stream操作的安全性
        displayObjectProviderStreamOps(applicationContext);
        applicationContext.close();
    }

    private static void displayObjectProviderStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectProviderStreamOps", () -> userObjectProvider.forEach(System.out::println));
    }

    private static void displayListableBeanFactoryGetBeansOfType(ListableBeanFactory beanFactory) {
        printBeansException("displayListableBeanFactoryGetBeansOfType", () -> beanFactory.getBeansOfType(User.class));
    }

    private static void displayObjectProviderGetIfAvaiable(BeanFactory beanFactory) {
        ObjectProvider<User> userObjectProvider = beanFactory.getBeanProvider(User.class);
        printBeansException("displayObjectProviderGetIfAvaiable", () -> userObjectProvider.getIfAvailable());
    }

    private static void displayObjectFactoryGetObject(BeanFactory beanFactory) {
        ObjectFactory<User> userObjectFactory = beanFactory.getBeanProvider(User.class);
        printBeansException("displayObjectFactoryGetObject", () -> userObjectFactory.getObject());
    }

    private static void displayBeanFactoryGetBean(BeanFactory beanFactory) {
        printBeansException("displayBeanFactoryGetBean", () -> beanFactory.getBean(User.class));
    }

    private static void printBeansException(String source, Runnable runnable) {
        System.err.println("==============================================");
        System.err.println("source from: " + source);
        try {
            runnable.run();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
