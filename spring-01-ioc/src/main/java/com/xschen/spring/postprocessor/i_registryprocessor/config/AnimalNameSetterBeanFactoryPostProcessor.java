package com.xschen.spring.postprocessor.i_registryprocessor.config;

import com.xschen.spring.postprocessor.i_registryprocessor.bean.Animal;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * @author xschen
 *
 * Animal的后置处理器, 给所有的Animal赋属性值
 *
 *              BeanPostProcessor	                    BeanFactoryPostProcessor	                        BeanDefinitionRegistryPostProcessor
 * 处理目标	    bean 实例	                            BeanDefinition	                                    BeanDefinition 、.class 文件等
 * 执行时机	    bean 的初始化阶段前后                   	BeanDefinition 解析完毕并注册进 BeanFactory 之后,	    配置文件、配置类已解析完毕并注册进 BeanFactory ，
 *              （已创建出 bean 对象）;                     （此时 bean 未实例化）;                               但还没有被 BeanFactoryPostProcessor 处理;
 * 可操作的空间	给 bean 的属性赋值、创建代理对象等;	        给 BeanDefinition 中增删属性、移除 BeanDefinition 等;	向 BeanFactory 中注册新的 BeanDefinition;
 */

//@Component
public class AnimalNameSetterBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("AnimalNameSetterPostProcessor postProcessBeanFactory run ......");
        String[] animalNames = beanFactory.getBeanNamesForType(Animal.class);
        Stream.of(animalNames).forEach(name -> {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            beanDefinition.getPropertyValues().add("name", name);
        });
    }
}
