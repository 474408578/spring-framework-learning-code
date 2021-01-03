package com.think.in.spring.bean.definition;

import com.think.in.spring.bean.factory.DefaultUserFactory;
import com.think.in.spring.bean.factory.UserFactory;
import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Bean 初始化示例
 *
 * @author xschen
 */


@Configuration // Configuration class
public class BeanInitializationDemo {

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册Configuration class
        applicationContext.register(BeanInitializationDemo.class);

        // 启动Spring应用上下文
        applicationContext.refresh();

        UserFactory userFactory = applicationContext.getBean(UserFactory.class);

        // 非延迟初始化在 Spring 应用上下文启动完成后，被初始化
        System.out.println("Spring应用上下文准备关闭");
        // 关闭Spring应用上下文
        applicationContext.close();
        System.out.println("Spring应用上下文已关闭");
    }

    @Bean(initMethod = "initUserFactory", destroyMethod = "destoryUserFactory")
    @Lazy(value = false)
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}
