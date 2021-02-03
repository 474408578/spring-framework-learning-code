package com.think.in.spring.bean.lifecycle;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * BeanDefinition 合并示例
 * @author xschen
 * 
 * @see GenericBeanDefinition
 * @see RootBeanDefinition
 * @see DefaultListableBeanFactory#registerBeanDefinition(String, BeanDefinition)
 * @see ConfigurableBeanFactory#getMergedBeanDefinition(String)
 */
public class MergedBeanDefinitionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String location = "META-INF/dependency-lookup-context.xml";
        Resource resource = new ClassPathResource(location);
        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(resource);
        System.out.println("已加载的 BeanDefinition 数量：" + beanNumbers);
        // 通过Bean id 和类型进行 依赖查找
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
        User superUser = beanFactory.getBean("superUser", User.class);
        System.out.println(superUser);
    }
}
