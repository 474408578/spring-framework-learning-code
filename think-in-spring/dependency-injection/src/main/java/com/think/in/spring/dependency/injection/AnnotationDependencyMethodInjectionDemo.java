package com.think.in.spring.dependency.injection;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 基于Java注解的依赖方法注入方法示例
 * @author xschen
 */


public class AnnotationDependencyMethodInjectionDemo {

    private UserHolder userHolder;

    private UserHolder userHolder2;

    @Autowired
    public void initUserHolder(UserHolder userHolder) {
        this.userHolder = userHolder;
    }

    @Resource
    public void initUserHolder2(UserHolder userHolder) {
        this.userHolder2 = userHolder;
    }

    // 通过setter注入userHolder到IOC容器
    @Bean
    public UserHolder userHolder(User user) {
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotationDependencyMethodInjectionDemo.class);

        loadUserBeanDefinition(applicationContext);

        // 启动应用上下文
        applicationContext.refresh();

        AnnotationDependencyMethodInjectionDemo demo = applicationContext.getBean(AnnotationDependencyMethodInjectionDemo.class);
        // @AutoWired字段关联
        System.out.println("demo.userHolder: " + demo.userHolder);
        System.out.println("demo.userHolde2: " + demo.userHolder2);
        System.out.println("demo.userHolder == demo.userHolder2: " + (demo.userHolder == demo.userHolder2));

        // 关闭应用上下文
        applicationContext.close();

    }

    private static void loadUserBeanDefinition(AnnotationConfigApplicationContext applicationContext) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        // 加载XML资源，解析并生成BeanDefinition
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(xmlResourcePath);
    }
}
