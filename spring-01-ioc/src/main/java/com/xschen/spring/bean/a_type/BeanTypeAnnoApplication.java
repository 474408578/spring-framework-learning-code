package com.xschen.spring.bean.a_type;

import com.xschen.spring.bean.a_type.bean.Toy;
import com.xschen.spring.bean.a_type.bean.ToyFactoryBean;
import com.xschen.spring.bean.a_type.config.BeanTypeConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author xschen
 * todo: 注册了两个Ball的bean
 */


public class BeanTypeAnnoApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanTypeConfiguration.class);
        /**
         * 取出FactoryBean生产的Bean
         * beanName, bean
         */
        Map<String, Toy> toys = ctx.getBeansOfType(Toy.class);
        toys.forEach((name, toy) -> {
            System.out.println("toy name: " + name + ", " + toy.toString());
        });

        /**
         * 是否单例
         */
        Toy toy1 = ctx.getBean(Toy.class);
        Toy toy2 = ctx.getBean(Toy.class);
        System.out.println(toy1 == toy2);

        ToyFactoryBean factoryBean = ctx.getBean(ToyFactoryBean.class);
        System.out.println(factoryBean);

        // 传bean id的话，取出的是生产出来的bean
        System.out.println(ctx.getBean("toyFactory"));
        // 传bean id，在前面加&符号，可以去除Factory Bean本体
        System.out.println(ctx.getBean("&toyFactory"));

    }
}
