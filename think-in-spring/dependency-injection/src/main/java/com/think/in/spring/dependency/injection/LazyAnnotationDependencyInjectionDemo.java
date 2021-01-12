package com.think.in.spring.dependency.injection;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Iterator;
import java.util.Set;


/**
 * {@link ObjectFactory } 延迟注入
 * {@link ObjectProvider } 延迟注入
 * @see Qualifier
 * @author xschen
 */

public class LazyAnnotationDependencyInjectionDemo {

    @Autowired
    @Qualifier("user")
    private User user; // 实时注入

    @Autowired
    private ObjectProvider<User> userObjectProvider; // 延迟注入

    @Autowired
    @Qualifier("user")
    private ObjectFactory<Set<User>> userObjectFactories;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(LazyAnnotationDependencyInjectionDemo.class);
        loadUserBeanDefinition(applicationContext);
        applicationContext.refresh();
        LazyAnnotationDependencyInjectionDemo demo = applicationContext.getBean(LazyAnnotationDependencyInjectionDemo.class);


        // user
        displayUserByRealTime(demo.user);
        // user, superUser
        displayUsersByObjectProvider(demo.userObjectProvider);
        // user
        displayUsersByObjectFactory(demo.userObjectFactories);

        applicationContext.close();
    }

    private static void displayUserByRealTime(User user) {
        System.out.println("demo.user: ");
        System.out.println( user);
        System.out.println("------------------------------------------");
    }

    private static void displayUsersByObjectFactory(ObjectFactory<Set<User>> userObjectFactories) {
        System.out.println("ObjectFactory：");
        Set<User> users = userObjectFactories.getObject();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("------------------------------------------");
    }

    private static void displayUsersByObjectProvider(ObjectProvider<User> userObjectProvider) {
        System.out.println("ObjectProvider: ");
        userObjectProvider.forEach(System.out::println);
//        Iterator userIterator = userObjectProvider.iterator();
//        while (userIterator.hasNext()) {
//            System.out.println(userIterator.next());
//        }
        System.out.println("---------------------------------------------");

    }

    private static void loadUserBeanDefinition(AnnotationConfigApplicationContext applicationContext) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
    }
}
