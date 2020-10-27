package com.xschen.spring.postprocessor.d_factorybean;

import com.xschen.spring.postprocessor.d_factorybean.bean.Egg;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class FactoryBeanPostProcessorApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.xschen.spring.postprocessor.d_factorybean");

        /**
         * 没有打印Egg的初始化触发，是因为FactoryBean的生命周期与IOC容器一致，而FactoryBean生产bean的时机是延迟创建的
         *
         * javadoc:BeanPostProcessor 提供了两个回调时机：
         * bean 的初始化之前和 bean 的初始化之后，它们分别适合做填充和代理的工作。
         */
        Egg egg = ctx.getBean(Egg.class);
        System.out.println(egg);

    }
}
