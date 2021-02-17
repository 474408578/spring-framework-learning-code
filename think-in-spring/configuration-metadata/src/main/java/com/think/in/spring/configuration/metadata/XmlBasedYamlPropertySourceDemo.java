package com.think.in.spring.configuration.metadata;

import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.config.YamlProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * 基于XMl 资源的 YAML 外部化配置示例
 * @author xschen
 * @see YamlMapFactoryBean
 * @see YamlProcessor
 */
public class XmlBasedYamlPropertySourceDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:/META-INF/yaml-property-source.xml");

        Map<String, Object> yamlMap = beanFactory.getBean("yamlMap", Map.class);
        System.out.println(yamlMap);

    }
}
