package com.xschen.spring.postprocessor.e_instantiation;

import com.xschen.spring.postprocessor.e_instantiation.bean.Ball;
import com.xschen.spring.postprocessor.e_instantiation.config.BallFactoryInstantiationProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
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
