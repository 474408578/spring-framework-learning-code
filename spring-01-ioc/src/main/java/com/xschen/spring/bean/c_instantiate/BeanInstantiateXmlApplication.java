package com.xschen.spring.bean.c_instantiate;

import com.xschen.spring.bean.c_instantiate.bean.*;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xschen
 */


public class BeanInstantiateXmlApplication {
    public static void main(String[] args) throws Exception {

        ApplicationContext ctx  = new ClassPathXmlApplicationContext("bean/bean-instantiate.xml");
        ctx.getBeansOfType(Car.class).forEach((name, car) -> {
            System.out.println(name + ": " + car);
        });

        // 尝试取一下静态工厂，看是否在IOC容器中。结果抛出异常，显示静态工厂本身不会被注入到IOC容器中
//        System.out.println(ctx.getBean(CarStaticFactory.class));

        // 尝试取一下实例工厂，看是否在IOC容器中，结果显示在IOC容器中
        System.out.println(ctx.getBean(CarInstanceFactory.class));
    }
}
