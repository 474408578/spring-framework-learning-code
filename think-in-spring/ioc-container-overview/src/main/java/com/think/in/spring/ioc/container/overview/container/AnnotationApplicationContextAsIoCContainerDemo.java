package com.think.in.spring.ioc.container.overview.container;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * {@link org.springframework.context.ApplicationContext} 作为IOC容器示例
 * @author xschen
 */


public class AnnotationApplicationContextAsIoCContainerDemo {

    public static void main(String[] args) {
        // 创建ApplicationContext
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // 将当前类AnnotationApplicationContextAsIoCContainerDemo作为配置类
        ctx.register(AnnotationApplicationContextAsIoCContainerDemo.class);
        // 启动应用上下 文
        ctx.refresh();
        lookupCollectionByType(ctx);

        // 关闭应用上下文
        ctx.close();
    }

    /**
     * 通过Java注解的方式，定义了一个bean
     * @return
     */
    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("xschen");
        return user;
    }

    private static void lookupCollectionByType(ApplicationContext ctx) {
        if (ctx instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) ctx;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有User集合对象： " + users);
        }
    }
}
