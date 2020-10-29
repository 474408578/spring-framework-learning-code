package com.xschen.spring.programmatic.a_quickstart;

import com.xschen.spring.programmatic.a_quickstart.bean.Person;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class ProgrammaticQuickStartApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        BeanDefinition personDefinition = BeanDefinitionBuilder
                .rootBeanDefinition(Person.class)
                .addPropertyValue("name", "zhangsan")
                .getBeanDefinition();
        ctx.registerBeanDefinition("person", personDefinition);
        // 需要手动refresh
        ctx.refresh();

        Person person = ctx.getBean(Person.class);
        System.out.println(person);
    }
}
