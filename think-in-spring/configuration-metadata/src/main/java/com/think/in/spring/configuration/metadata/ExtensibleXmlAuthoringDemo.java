package com.think.in.spring.configuration.metadata;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Spring XML 元素扩展示例
 * @author xschen
 */
public class ExtensibleXmlAuthoringDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/user-context.xml");

        // 依赖查找，获取 user bean 对象
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }
}
