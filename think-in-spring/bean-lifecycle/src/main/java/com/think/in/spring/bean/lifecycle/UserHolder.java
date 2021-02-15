package com.think.in.spring.bean.lifecycle;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xschen
 * @see AbstractAutowireCapableBeanFactory ：invokeAwareMethods(String, Object)
 *              BeanNameAware, BeanClassLoaderAware, BeanFactoryAware
 *
 *      ApplicationContextAwareProcessor#invokeAwareInterfaces
 *              EnvironmentAware,
 *
 */
public class UserHolder implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware,
        EnvironmentAware, InitializingBean, SmartInitializingSingleton, DisposableBean {
    private final User user;

    private Integer number;

    private String description;

    private String beanName;
    private ClassLoader beanClassLoader;
    private BeanFactory beanFactory;
    private Environment environment;

    public UserHolder(User user) {
        this.user = user;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.beanClassLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * 依赖于注解驱动
     * 当前场景：BeanFactory
     */
    @PostConstruct
    public void initPostConstruct() {
        // postProcessBeforeInitialization V3 -> initPostConstruct V4
        this.description = "The user holder V4";
        System.out.println("initPostConstruct() = " + description);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // initPostConstruct V4 -> afterPropertiesSet V5
        this.description = "The user holder V5";
        System.out.println("afterPropertiesSet() = " + description);
    }

    /**
     * 自定义初始化方法
     */
    public void init() {
        // initPostConstruct V5 -> afterPropertiesSet V6
        this.description = "The user holder V6";
        System.out.println("init() = " + description);
    }

    @Override
    public void afterSingletonsInstantiated() {
        // postProcessAfterInitialization v7 -> v8
        this.description = "The user holder V8";
        System.out.println("afterSingletonsInstantiated() = " + description);
    }

    @PreDestroy
    public void preDestroy() {
        // postProcessBeforeDestruction V9 -> V10
        this.description = "The user holder V10";
        System.out.println("preDestroy() = " + description);
    }

    @Override
    public void destroy() throws Exception {
        // preDestroy() v10 -> V11
        this.description = "The user holder V11";
        System.out.println("destroy() = " + description);
    }

    public void doDestroy() {
        // destroy() v11 -> v12
        this.description = "The user Holder V12";
        System.out.println("doDestroy() = " + description);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("The UserHolder is finalized...");
        super.finalize();
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                ", number=" + number +
                ", description='" + description + '\'' +
                ", beanName='" + beanName + '\'' +
                '}';
    }
}
