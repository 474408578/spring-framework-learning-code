package com.xschen.spring.basic_di.i_lazyinject;

import com.xschen.spring.basic_di.i_lazyinject.bean.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class LazyInjectAnnoApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.xschen.spring.basic_di.i_lazyinject.bean");

        Dog dog = ctx.getBean(Dog.class);
        System.out.println(dog);


    }

}
