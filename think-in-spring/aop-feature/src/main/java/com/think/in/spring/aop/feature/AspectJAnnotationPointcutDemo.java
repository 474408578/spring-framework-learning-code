package com.think.in.spring.aop.feature;

import com.think.in.spring.aop.feature.aspect.AspectConfiguration;
import com.think.in.spring.aop.feature.aspect.AspectConfiguration2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Random;

/**
 * Pointcut 表达式 示例
 * @author xschen
 * @date 2021/9/20 18:33
 */

@Configuration
@EnableAspectJAutoProxy // 激活 AspectJ 自动代理
public class AspectJAnnotationPointcutDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AspectJAnnotationPointcutDemo.class,
                AspectConfiguration.class,
                AspectConfiguration2.class);
        context.refresh();

        AspectJAnnotationPointcutDemo demo = context.getBean(AspectJAnnotationPointcutDemo.class);
        demo.execute();
        context.close();
    }

    public void execute() {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new RuntimeException("For Purpose.");
        }
        System.out.println("execute...");
    }
}
