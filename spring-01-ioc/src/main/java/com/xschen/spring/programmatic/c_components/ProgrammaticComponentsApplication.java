package com.xschen.spring.programmatic.c_components;

import com.xschen.spring.programmatic.c_components.bean.Animal;
import com.xschen.spring.programmatic.c_components.bean.Cat;
import com.xschen.spring.programmatic.c_components.bean.Person;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.io.ClassPathResource;

import java.beans.Introspector;
import java.util.Set;

/**
 * @author xschen
 * @see ClassPathBeanDefinitionScanner
 */

public class ProgrammaticComponentsApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        BeanDefinition personBeanDefinition = BeanDefinitionBuilder
                .rootBeanDefinition(Person.class)
                .addPropertyValue("name", "老王").getBeanDefinition();
        ctx.registerBeanDefinition("laowang", personBeanDefinition);

        // 类路径下的包扫描器
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(ctx);
        scanner.addIncludeFilter((metadataReader, metadataReaderFactory) -> {
            // getClassMetadata可以获取到扫描类的相关元信息，此处把Animal的子类都拿出来
            return metadataReader.getClassMetadata()
                    .getSuperClassName()
                    .equals(Animal.class.getName());
        });

        // 返回扫描到的 BeanDefinition 集合
        Set<BeanDefinition> animalDefinitions = scanner
                .findCandidateComponents("com.xschen.spring.programmatic.c_components.bean");

        animalDefinitions.forEach(beanDefinition -> {
            // 初始化Animal子类对象
            MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
            String beanClassName = beanDefinition.getBeanClassName();
            propertyValues.addPropertyValue("name",beanClassName);
            propertyValues.addPropertyValue("person", new RuntimeBeanReference("laowang"));
            ctx.registerBeanDefinition(Introspector.decapitalize(beanClassName.substring(beanClassName.lastIndexOf("."))),
                    beanDefinition);
        });


        ctx.refresh();
        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);

    }
}
