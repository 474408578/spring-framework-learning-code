package com.think.in.spring.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * byName AutoWiring 依赖Setter注入 示例
 * @author xschen
 */


public class AutoWiringByNameDependencySetterInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader= new XmlBeanDefinitionReader(beanFactory);
        String xmlResourcePath = "classpath:/META-INF/autowiring-dependency-setter-injection.xml";
        // 加载xml资源，解析并生成BeanDefinition
        reader.loadBeanDefinitions(xmlResourcePath);
        // 依赖查找并创建Bean
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println(userHolder);
    }
}