package com.think.in.spring.ioc.container.overview.container;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;


/**
 * {@link org.springframework.beans.factory.BeanFactory}IOC容器示例
 * BeanFactory是Spring的底层容器
 * @author xschen
 */


public class BeanFactoryAsIoCContainerDemo {

    public static void main(String[] args) {
        // 创建BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // xml配置文件 classpath路径
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载配置
        int beanDefinitionCount = reader.loadBeanDefinitions(location);
        System.out.println("Bean定义加载的数量： " + beanDefinitionCount);

        // 依赖查找集合对象
        lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有User集合对象： " + users);
        }
    }

}
