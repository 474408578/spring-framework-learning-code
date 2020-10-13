package com.xschen.spring.bean.c_instantiate;

import com.xschen.spring.bean.c_instantiate.bean.Ball;
import com.xschen.spring.bean.c_instantiate.config.BeanInstantiateConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class BeanInstantiateAnnoApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanInstantiateConfiguration.class);
        ctx.getBeansOfType(Ball.class).forEach((name, object) -> {
            System.out.println(name + ": " + object);
        });
    }
}
