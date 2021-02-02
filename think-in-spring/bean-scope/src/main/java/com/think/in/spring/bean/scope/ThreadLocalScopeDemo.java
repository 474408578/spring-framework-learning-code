package com.think.in.spring.bean.scope;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * 自定义 {@link ThreadLocalScope} 示例
 * @author xschen
 */


public class ThreadLocalScopeDemo {

    @Bean
    @Scope(ThreadLocalScope.SCOPE_NAME)
    public User user() {
        return createUser();
    }

    public static User createUser() {
        User user = new User();
        user.setId(System.currentTimeMillis());
        return user;
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ThreadLocalScopeDemo.class);
        context.addBeanFactoryPostProcessor(beanFactory -> {
            // 注册自定义Scope
            beanFactory.registerScope(ThreadLocalScope.SCOPE_NAME, new ThreadLocalScope());
        });
        context.refresh();

        scopedBeansByLookup(context);
        context.close();
    }

    private static void scopedBeansByLookup(AnnotationConfigApplicationContext context) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            // 线程级别，user不是共享对象
            Thread thread = new Thread(() -> {
                User user = context.getBean("user", User.class);
                System.out.printf("[Thread Id: %d] user = %s%n", Thread.currentThread().getId(), user);
            });
            thread.start();
            thread.join();

            // User 是共享对象
//            User user = context.getBean("user", User.class);
//            System.out.printf("[Thread Id: %d] user = %s%n", Thread.currentThread().getId(), user);
        }
    }
}
