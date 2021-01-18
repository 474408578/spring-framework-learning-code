package com.think.in.spring.dependency.source;


import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * 外部化配置作为依赖来源示例
 * @see AutowiredAnnotationBeanPostProcessor#AutowiredAnnotationBeanPostProcessor()
 * @author xschen
 */

@Configuration
@PropertySource(value = "classpath:/META-INF/default.properties", encoding = "UTF-8")
public class ExternalConfigurationDependencySourceDemo {

    @Value("${user.id:-1}") // 如果不存在，则使用默认值-1
    private Long id;

    @Value("${user.name}")
    private String name;

    @Value("${user.resource:classpath:/default.properties}") // 如果不存在，则使用默认值classpath:/default.properties
    private Resource resource;


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ExternalConfigurationDependencySourceDemo.class);

        applicationContext.refresh();
        ExternalConfigurationDependencySourceDemo demo = applicationContext.getBean(ExternalConfigurationDependencySourceDemo.class);

        System.out.println("demo.id = " + demo.id);
        System.out.println("demo.name = " + demo.name);
        System.out.println("demo.resource = " + demo.resource);
        applicationContext.close();
    }
}
