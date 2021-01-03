package com.think.in.spring.bean.definition;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 实例化示例
 * @author xschen
 */


public class BeanInstantiationDemo {

    public static void main(String[] args) {
        // 配置XML文件
        // 启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");

        User user = (User) beanFactory.getBean("user-by-static-method");
        User userByInstanceMethod = (User) beanFactory.getBean("user-by-instance-method");
        User userByFactoryBean = (User) beanFactory.getBean("user-by-factory-bean");

        System.out.println(user);
        System.out.println(userByInstanceMethod);
        System.out.println(userByFactoryBean);
        System.out.println("user == userByInstanceMethod: " + (user == userByInstanceMethod));
        System.out.println("user == userByFactoryBean: " + (user == userByFactoryBean));



    }
}
