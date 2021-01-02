package com.think.in.spring.ioc.container.overview.dependency.injection;

import com.think.in.spring.ioc.container.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖注入示例
 * 依赖注入来源和依赖查找来源不同
 * 依赖注入的来源：
 *      1、自定义的bean
 *      2、容器内建bean对象
 *      3、容器内建依赖（不能通过依赖查找拿到）
 * @author xschen
 */


public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // 配置 xml文件
        // 启动 应用上下文
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        // 依赖来源一：自定义的Bean
        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        System.out.println(userRepository.getUsers());

        // 依赖来源二：依赖注入（此处的Bean是内建的依赖），非Bean，不能通过依赖查找的方式来获取
        System.out.println("userRepository.getBeanFactory(): " + userRepository.getBeanFactory());

        System.out.println("beanFactory：" + applicationContext);

        // 依赖查找(错误)
//        System.out.println(beanFactory.getBean(BeanFactory.class));


        ObjectFactory objectFactory = userRepository.getObjectFactory();
        System.out.println(objectFactory.getObject());

        // 依赖来源三：容器内建Bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("获取Environment类型的Bean： " + environment);
    }


    public static void whoIsIoCContainer(UserRepository userRepository, ApplicationContext applicationContext) {
        // 这个表达式为什么不成立
        System.out.printf("userRepository.getBeanFactory() == beanFactory: %b \n", userRepository.getBeanFactory() == applicationContext);

        // ApplicationContext就是一个BeFactory
    }
}
