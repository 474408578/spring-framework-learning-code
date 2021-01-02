package com.think.in.spring.ioc.container.overview.dependency.lookup;

import com.think.in.spring.ioc.container.overview.annotation.Super;
import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * 1. 通过名称来查找：
 *      实时查找
 *      延迟查找
 *
 * 2. 通过类型来查找
 *      单个Bean对象
 *      集合Bean对象
 *
 * 3. 通过注解查找
 *
 * @author xschen
 */


public class DependencyLookUpDemo {

    public static void main(String[] args) {
        // 配置 xml文件
        // 启动 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");


        // 根据名称查找
        // 实时查找
        lookupInRealTime(beanFactory);
        // 延迟查找
        lookupInLazy(beanFactory);

        // 根据类型查找
        // 单一类型
        lookupByType(beanFactory);
        // 复合类型
        lookupByCollectionType(beanFactory);

        // 根据注解进行查找
        lookupByAnnotation(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("根据注解实时查找@Super标注的集合对象：" + users);
        }
    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("根据类型实时查找到的集合对象：" + users);
        }
    }


    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("根据类型实时查找：" + user);
    }

    public static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("根据名称实时查找：" + user);
    }

    public static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("根据名称延迟查找：" + user);
    }

}
