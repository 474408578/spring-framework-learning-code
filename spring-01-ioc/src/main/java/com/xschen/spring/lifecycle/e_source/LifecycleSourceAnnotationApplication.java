package com.xschen.spring.lifecycle.e_source;

import com.xschen.spring.lifecycle.e_source.bean.Cat;
import com.xschen.spring.lifecycle.e_source.bean.Person;
import com.xschen.spring.lifecycle.e_source.config.LifecycleConfiguration;
import com.xschen.spring.lifecycle.e_source.config.LifecycleDestructionPostProcessor;
import com.xschen.spring.lifecycle.e_source.config.LifecycleNameReadBeanPostProcessor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 * @see BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry(BeanDefinitionRegistry) 
 * @see BeanFactoryPostProcessor#postProcessBeanFactory(ConfigurableListableBeanFactory)
 * @see InstantiationAwareBeanPostProcessor
 * @see BeanPostProcessor
 * @see DestructionAwareBeanPostProcessor
 */


public class LifecycleSourceAnnotationApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(LifecycleDestructionPostProcessor.class);
        ctx.register(LifecycleNameReadBeanPostProcessor.class);
        ctx.register(LifecycleConfiguration.class);

        System.out.println("=======================刷新IOC容器========================");

        ctx.refresh();

        System.out.println("=======================IOC容器刷新完毕========================");

        ctx.start();

        System.out.println("=======================IOC容器启动完成========================");

        Person person = ctx.getBean(Person.class);
        System.out.println(person);

        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);

        System.out.println("=======================准备停止IOC容器========================");

        ctx.stop();

        System.out.println("=======================IOC容器停止成功========================");

        ctx.close();
    }
}
