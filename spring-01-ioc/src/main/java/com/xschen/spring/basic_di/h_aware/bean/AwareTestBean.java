package com.xschen.spring.basic_di.h_aware.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.stream.Stream;

/**
 * @author xschen
 * todo: 回调注入
 * 当aware被初始化好的时候，就会把ApplicationContext传给它
 *
 */


public class AwareTestBean implements ApplicationContextAware, BeanNameAware {
    private ApplicationContext ctx;

    // 当前的bean依赖它本身的name, 需要使用BeanNameAware接口来辅助注入当前bean的name
    private String beanName;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }


    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void printBeanNames() {
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }


}
