package com.think.in.spring.dependency.injection;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 基于Java注解的依赖字段注入方法示例
 * @author xschen
 */


public class AnnotationDependencyFieldInjectionDemo {

    // 通过@Autowired获取userHolder并注入到字段userHolder中。
    @Autowired
    private
    static // @AutoWired和@Resource都会忽略掉静态字段
    UserHolder userHolder;

    @Resource
    private UserHolder userHolder2;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotationDependencyFieldInjectionDemo.class);

        loadUserBeanDefinition(applicationContext);

        // 启动应用上下文
        applicationContext.refresh();

        AnnotationDependencyFieldInjectionDemo demo = applicationContext.getBean(AnnotationDependencyFieldInjectionDemo.class);
        // @AutoWired字段关联
        System.out.println("demo.userHolder: " + demo.userHolder);
        System.out.println("demo.userHolde2: " + demo.userHolder2);
        System.out.println("demo.userHolder == demo.userHolder2: " + (demo.userHolder == demo.userHolder2));

        // 关闭应用上下文
        applicationContext.close();

    }

    // 通过setter注入userHolder到IOC容器
    @Bean
    public UserHolder userHolder(User user) {
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }

    private static void loadUserBeanDefinition(AnnotationConfigApplicationContext applicationContext) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        // 加载XML资源，解析并生成BeanDefinition
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(xmlResourcePath);
    }
}
