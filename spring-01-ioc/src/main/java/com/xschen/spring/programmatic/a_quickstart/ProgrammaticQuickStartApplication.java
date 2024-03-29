package com.xschen.spring.programmatic.a_quickstart;

import com.xschen.spring.programmatic.a_quickstart.bean.Person;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 *
 * 不使用任何配置类/配置文件，向IOC容器注册一个Person对象，并注入属性值
 * @see AnnotationConfigApplicationContext#AnnotationConfigApplicationContext(Class[])  无需手动refresh()
 * @see AnnotationConfigApplicationContext#AnnotationConfigApplicationContext() 需要手抖动refresh()
 */


public class ProgrammaticQuickStartApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        BeanDefinition personDefinition = BeanDefinitionBuilder
                .rootBeanDefinition(Person.class)
                .addPropertyValue("name", "zhangsan")
                .getBeanDefinition();
        ctx.registerBeanDefinition("person", personDefinition);
        // 在ApplicationContext的落地实现中，如果预先没有传入配置文件/配置类/包扫描路径的话，需要手动refresh
        ctx.refresh();

        Person person = ctx.getBean(Person.class);
        System.out.println(person);
    }
}
