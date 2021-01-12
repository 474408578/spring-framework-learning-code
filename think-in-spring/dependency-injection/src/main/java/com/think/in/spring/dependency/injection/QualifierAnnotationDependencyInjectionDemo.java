package com.think.in.spring.dependency.injection;

import com.think.in.spring.dependency.injection.annotation.UserGroup;
import com.think.in.spring.dependency.injection.config.QualifierConfiguration;
import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Collection;


/**
 * {@link Qualifier} 注解依赖注入
 * @author xschen
 */

public class QualifierAnnotationDependencyInjectionDemo {

    @Autowired
    private User user; // superUser: primary = true

    @Autowired
    @Qualifier("user") // 指定bean名称或者ID
    private User namedUser;

    @Autowired
    private Collection<User> allUsers;

    @Autowired
    @Qualifier
    private Collection<User> qualifiedUsers;

    @Autowired
    @UserGroup
    private Collection<User> userGroupUsers;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(QualifierAnnotationDependencyInjectionDemo.class);
        // 注册外部配置类
        applicationContext.register(QualifierConfiguration.class);


        loadUserBeanDefinition(applicationContext);
        applicationContext.refresh();
        QualifierAnnotationDependencyInjectionDemo demo = applicationContext.getBean(QualifierAnnotationDependencyInjectionDemo.class);

        // expect output "superUser" bean
        System.out.println("demo.user = " + demo.user);

        // expect output "user" bean
        System.out.println("demo.namedUser = " + demo.namedUser);

        // expect output "superUser", "user", "user1", "user2", "user3", "user4"
        System.out.println("demo.allUsers = " + demo.allUsers);

        // expect output "user1", "user2", "user3", "user4"
        System.out.println("demo.qualifiedUsers = " + demo.qualifiedUsers);

        // expect output "user3", "user4"
        System.out.println("demo.userGroupUsers = " + demo.userGroupUsers);
    }

    private static void loadUserBeanDefinition(AnnotationConfigApplicationContext applicationContext) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载xml资源，解析并生成BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
    }


}
