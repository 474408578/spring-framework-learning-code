package com.think.in.spring.configuration.metadata;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

/**
 * {@link PropertiesBeanDefinitionReader} 示例
 * @author xschen
 * @see PropertiesBeanDefinitionReader
 */
public class PropertiesBeanDefinitionReaderDemo {

    public static void main(String[] args) {
        // 创建 IOC 底层容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 创建面向资源 Properties 的 BeanDefinitionReader
        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);

        // Properties 资源加载默认通过 ISO-8859-1，实际存储 UTF-8
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/META-INF/user-bean-definitions.properties");
        // 转换成带有字符编码 EncodedResource 对象
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        int beanDefinitionCount = beanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.println(String.format("已加载 %d 个BeanDefinition\n", beanDefinitionCount));

        // 通过依赖查找 User
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }
}
