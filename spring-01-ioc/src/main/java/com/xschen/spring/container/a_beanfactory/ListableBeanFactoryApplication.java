package com.xschen.spring.container.a_beanfactory;

import com.xschen.spring.container.a_beanfactory.bean.Dog;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author xschen
 */


public class ListableBeanFactoryApplication {

    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("container/listable-container.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions(resource);

        // 直接打印容器中的bean
        System.out.println("加载xml文件后容器的bean: ");
        Stream.of(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println();


        // 手动注册一个单实例的bean
        beanFactory.registerSingleton("doggg", new Dog());
        System.out.println("手动注册单实例Bean后容器中的所有Bean：");
        // ListableBeanFactory 在获取容器内所有 Bean 时真的不会把这些手动注册的拿出来()getBeanNamesOfType 和 getBeansOfType 除外
        Stream.of(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);
        /**
         * 手动注册单实例Bean后容器中的所有Bean：
         * com.xschen.spring.container.a_beanfactory.bean.Cat#0
         */

        System.out.println("容器中真的有注册Dog: " + beanFactory.getBean(Dog.class));
        // 通过getBeanNamesOfType查找dog
        // getBeanNamesOfType 和 getBeansOfType 除外，它们也会检查这种手动注册的单实例 Bean
        System.out.println("容器中的所有Dog：" + Arrays.toString(beanFactory.getBeanNamesForType(Dog.class)));

    }
}
