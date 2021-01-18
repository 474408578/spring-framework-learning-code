package com.think.in.spring.dependency.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * 依赖来源示例
 *
 * @author xschen
 * @see AbstractApplicationContext#refresh()
 *  prepareBeanFactory(ConfigurableListableBeanFactory)
 *      beanFactory.registerResolvableDependency(BeanFactory.class, beanFactory);
 * 		beanFactory.registerResolvableDependency(ResourceLoader.class, this);
 * 		beanFactory.registerResolvableDependency(ApplicationEventPublisher.class, this);
 * 		beanFactory.registerResolvableDependency(ApplicationContext.class, this);
 *
 * @see DefaultListableBeanFactory#resolveDependency(DependencyDescriptor, String)
 */


public class DependencySourceDemo {
    // @Autowired注入在AutowiredAnnotationBeanPostProcessor#postProcessProperties方法执行，
    // 早于setter注入，也早于@PostConstruct
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * 四个对象中有三个是相等的
     */
    @PostConstruct
    public void initByInjection() {
        System.out.println("beanFactory == applicationContext: " + (beanFactory == applicationContext));
        System.out.println("beanFactory == applicationContext.getAutowireCapableBeanFactory: " +
                (beanFactory == applicationContext.getAutowireCapableBeanFactory()));
        System.out.println("applicationEventPublisher == applicationContext: " + (applicationEventPublisher == applicationContext));
        System.out.println("resourceLoader == applicationContext: " + (resourceLoader == applicationContext));
    }

    /**
     * 全找不到，依赖注入和依赖查找的来源中，依赖注入比依赖查找多了一个 非Spring容器的管理对象 的来源
     * 也就是这4个对象不再Spring容器管理中
     */
    @PostConstruct
    public void initByLookup() {
        getBean(BeanFactory.class);
        getBean(ApplicationEvent.class);
        getBean(ApplicationEventPublisher.class);
        getBean(ResourceLoader.class);
    }

    private  <T> T getBean(Class<T> beanType) {
        try {
            return beanFactory.getBean(beanType);
        } catch (NoSuchBeanDefinitionException e) {
            System.err.println("当前类型" + beanType.getName() + "无法在BeanFactory中查找！");
        }
        return null;
    }

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(DependencySourceDemo.class);

        // 启动 Spring 应用上下文
        applicationContext.refresh();
        DependencySourceDemo demo = applicationContext.getBean(DependencySourceDemo.class);

        // 显示关闭Spring应用上下文
        applicationContext.close();
    }

}
