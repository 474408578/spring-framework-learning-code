package com.xschen.spring.bean.a_type;

import com.xschen.spring.bean.a_type.bean.Toy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xschen
 *
 *
 */


public class BeanTypeXmlApplication {
    public static void main(String[] args) {
        /**
         * xml文件中注入了ToyFactoryBean和Child，ToyFactoryBean实现了FactoryBean接口
         * 实现了FactoryBean接口的方法getObject，在这个方法中创建了对象ball
         */
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean/bean-type.xml");
        Toy toy = ctx.getBean(Toy.class);
        System.out.println(toy);
    }
}
