package com.think.in.spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 层次性依赖查找示例
 * @author xschen
 */


public class HierarchicalDependencyLookupDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(HierarchicalDependencyLookupDemo.class);

        // 1. 获取HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println("当前beanFactory的parent的beanFactory: " + beanFactory.getParentBeanFactory()); // null

        // 2. 设置Parent BeanFactory
        HierarchicalBeanFactory parentBeanfactory = createParentBeanfactory();
        beanFactory.setParentBeanFactory(parentBeanfactory);
        System.out.println("当前beanFactory的parent的beanFactory: " + beanFactory.getParentBeanFactory());

        // 层次性查找
        System.out.println("---------------------------------------------");
        displayContainsLocalBean(beanFactory, "user");
        displayContainsLocalBean(parentBeanfactory, "user");

        displayContainsBean(beanFactory, "user");
        displayContainsBean(parentBeanfactory, "user");

        applicationContext.refresh();
        applicationContext.close();
    }

    private static void displayContainsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前BeanFactory[%s] 是否包含 Bean[name : %s] : %s\n", beanFactory, beanName,
                containsBean(beanFactory, beanName));
    }

    private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        BeanFactory parentBeanfactory = beanFactory.getParentBeanFactory();
        if (parentBeanfactory instanceof HierarchicalBeanFactory) { // 双重判断，判空 + 判是否为HierarchicalBeanFactory
            // 强转为HierarchicalBeanFactory
            HierarchicalBeanFactory parentHierarchicalBeanFactory = HierarchicalBeanFactory.class.cast(parentBeanfactory);
            // 递归判断
            if (containsBean(parentHierarchicalBeanFactory, beanName)) {
                return true;
            }
        }
        return beanFactory.containsLocalBean(beanName);
    }

    private static void displayContainsLocalBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前BeanFactory[%s]是否包含Local Bean[name: %s]：%s \n",
                beanFactory, beanName, beanFactory.containsLocalBean(beanName));

    }

    private static HierarchicalBeanFactory createParentBeanfactory() {
        // 创建BeanFactory容器
        DefaultListableBeanFactory beanfatory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanfatory);
        // Xml配置文件 classpath配置文件路径
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(location);
        return beanfatory;
    }
}
