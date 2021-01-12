package com.think.in.spring.dependency.injection;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.beans.factory.config.DependencyDescriptor;
/**
 * 注解驱动的依赖处理过程
 * @author xschen
 * @see Qualifier
 * @see DependencyDescriptor
 */


public class AnnotationDependencyInjectionResolutionDemo {

    /**
     * DependencyDescriptor：
     *      required: true 必须
     *      eager: true 实时注入
     *      通过类型（User.class）
     *      字段名称（"user"）
     *      primary：true
     */
    @Autowired // 依赖查找（处理）
    private User user;





    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencyInjectionResolutionDemo.class);
        loadUserBeanDefinition(applicationContext);
        applicationContext.refresh();
        AnnotationDependencyInjectionResolutionDemo demo = applicationContext.getBean(AnnotationDependencyInjectionResolutionDemo.class);

        // expect output "superUser" bean
        System.out.println("demo.user = " + demo.user);


    }

    private static void loadUserBeanDefinition(AnnotationConfigApplicationContext applicationContext) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
    }
}
