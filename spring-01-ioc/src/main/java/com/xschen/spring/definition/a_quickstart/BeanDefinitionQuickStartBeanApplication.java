package com.xschen.spring.definition.a_quickstart;

import com.xschen.spring.definition.a_quickstart.config.BeanDefinitionQuickStartConfiguration;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class BeanDefinitionQuickStartBeanApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                BeanDefinitionQuickStartConfiguration.class);
        BeanDefinition personBeanDefinition = ctx.getBeanDefinition("person");
        System.out.println(personBeanDefinition);
        System.out.println(personBeanDefinition.getClass().getName());

    }
}
