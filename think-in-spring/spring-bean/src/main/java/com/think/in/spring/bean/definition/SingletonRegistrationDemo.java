package com.think.in.spring.bean.definition;

import com.think.in.spring.bean.factory.DefaultUserFactory;
import com.think.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 单体Bean注册示例
 *
 * @author xschen
 */


public class SingletonRegistrationDemo {

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 创建一个外部userFactory对象
        UserFactory userFactory = new DefaultUserFactory();
        SingletonBeanRegistry singletonBeanRegistry = applicationContext.getBeanFactory();

        // 注册单例对象
        singletonBeanRegistry.registerSingleton("userFactory", userFactory);

        // 启动Spring应用上下文
        applicationContext.refresh();

        // 通过依赖查找的方式来获取外部的userFactory
        UserFactory userFactoryByLookUp = applicationContext.getBean("userFactory", UserFactory.class);
        System.out.println("userFactory == userFactoryByLookUp: " + (userFactory == userFactoryByLookUp));

        // 关闭Spring应用上下文
        applicationContext.close();
    }
}
