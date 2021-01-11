package com.think.in.spring.dependency.injection;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 基于Java注解的依赖Constructor注入方法示例
 * @author xschen
 */


public class AnnotationDependencyConstructorInjectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotationDependencyConstructorInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        // 加载XML资源，解析并生成BeanDefinition
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(xmlResourcePath);

        // 启动应用上下文
        applicationContext.refresh();

        // 依赖查找并创建Bean
        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        // 因为dependency-lookup-context.xml设置了superUser为primary，所以获取到的是superUser属性
        System.out.println(userHolder);

        // 关闭应用上下文
        applicationContext.close();

    }

    @Bean
    public UserHolder userHolder(User user) {

        return new UserHolder(user);
    }
}
