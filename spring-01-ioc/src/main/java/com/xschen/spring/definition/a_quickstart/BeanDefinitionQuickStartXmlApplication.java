package com.xschen.spring.definition.a_quickstart;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xschen
 */


public class BeanDefinitionQuickStartXmlApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:definition/definition-beans.xml");
        BeanDefinition personBeanDefinition = ctx.getBeanFactory().getBeanDefinition("person");
        System.out.println(personBeanDefinition);
    }
}
