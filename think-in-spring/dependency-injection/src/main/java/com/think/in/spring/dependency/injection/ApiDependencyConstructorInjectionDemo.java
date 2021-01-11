package com.think.in.spring.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于Api的依赖Constructor注入方法示例
 * @author xschen
 */


public class ApiDependencyConstructorInjectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ApiDependencyConstructorInjectionDemo.class);

        loadUserBeanDefinition(applicationContext);

        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();
        applicationContext.registerBeanDefinition("userHolder", userHolderBeanDefinition);
        applicationContext.refresh();

        // 依赖查找并创建Bean
        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);

        // 关闭应用上下文
        applicationContext.close();

    }

    /**
     * 为userHolder生成BeanDefinition
     * @return
     */
    private static BeanDefinition createUserHolderBeanDefinition() {
        // 1. 通过BeanDefinitionBuilder 构建
        BeanDefinitionBuilder userHolderBeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        // 通过属性设置
        userHolderBeanDefinition.addConstructorArgReference("superUser");
        // 获取BeanDefinition实例
        return userHolderBeanDefinition.getBeanDefinition();
    }

    // 加载出User类型的BeanDefinition
    private static void loadUserBeanDefinition(AnnotationConfigApplicationContext applicationContext) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        // 加载XML资源，解析并生成BeanDefinition
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(xmlResourcePath);
    }
}
