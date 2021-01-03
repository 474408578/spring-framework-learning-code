package com.think.in.spring.bean.definition;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * 注解BeanDefinition 示例
 * @author xschen
 */

// 3. 通过@Import进行导入
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册Configuration class（配置类）
        applicationContext.register(Config.class);

        // 通过BeanDefinition注册API实现
        // 1. 命名Bean的注册方式
        registerBeanDefinition(applicationContext, "xschen-user-1", User.class);
        // 2. 非命名Bean的注册方式
        registerBeanDefinition(applicationContext, User.class);


        // 启动应用上下文
        applicationContext.refresh();

        // 按照类型依赖查找
        System.out.println("Config Bean 的所有bean： " + applicationContext.getBeansOfType(Config.class));
        System.out.println("User类型的所有bean： " + applicationContext.getBeansOfType(User.class));


        // 显示地关闭Spring应用上下文
        applicationContext.close();

    }

    /**
     * 命名Bean的注册方式
     * @param registry
     * @param beanName
     * @param beanClass
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry,
                                              String beanName,
                                              Class<?> beanClass) {
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(beanClass);
        beanDefinitionBuilder
                .addPropertyValue("id", 1)
                .addPropertyValue("name", "xschen");
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        if (StringUtils.hasText(beanName)) {
            // 注册 BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinition);
        } else {
            //
            BeanDefinitionReaderUtils.registerWithGeneratedName((AbstractBeanDefinition) beanDefinition, registry);
        }
    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry,
                                              Class<?> beanClass) {
        registerBeanDefinition(registry, null, User.class);
    }

    // 2. 定义当前类作为Spring Bean（组件）
    @Component
    public static class Config {
        // 1. 通过@Bean的方式定义
        @Bean(name = {"user", "xschen-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("xschen");
            return user;
        }
    }
}
