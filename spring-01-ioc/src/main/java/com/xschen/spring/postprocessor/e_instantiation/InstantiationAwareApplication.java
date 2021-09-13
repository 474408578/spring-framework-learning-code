package com.xschen.spring.postprocessor.e_instantiation;

import com.xschen.spring.postprocessor.e_instantiation.bean.Ball;
import com.xschen.spring.postprocessor.e_instantiation.config.BallFactoryInstantiationProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link InstantiationAwareBeanPostProcessor} 拦截并替换Bean的默认实例化动作及Bean的属性注入和自动装配演示。
 * @author xschen
 */


public class InstantiationAwareApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:postprocessor/instantiation.xml");

        Ball ball = (Ball) ctx.getBean("ball");
        System.out.println(ball);

        Ball ball2 = (Ball) ctx.getBean("ball2");
        System.out.println(ball2);


    }
}
