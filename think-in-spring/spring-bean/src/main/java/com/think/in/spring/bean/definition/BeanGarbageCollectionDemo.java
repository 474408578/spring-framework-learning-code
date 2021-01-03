package com.think.in.spring.bean.definition;

import com.think.in.spring.bean.factory.DefaultUserFactory;
import com.think.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * Bean 垃圾回收（GC）示例
 * @author xschen
 */


public class BeanGarbageCollectionDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册Configuration class
        applicationContext.register(BeanInitializationDemo.class);

        // 启动Spring应用上下文
        applicationContext.refresh();
        // 关闭Spring应用上下文
        applicationContext.close();
        // 强制触发GC
        System.gc();
        Thread.sleep(5000);
    }

}
