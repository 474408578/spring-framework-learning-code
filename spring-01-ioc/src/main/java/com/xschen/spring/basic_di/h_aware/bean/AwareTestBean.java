package com.xschen.spring.basic_di.h_aware.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.NamedBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.stream.Stream;

/**
 * @author xschen
 * todo: 回调注入
 * 当aware被初始化好的时候，就会把ApplicationContext传给它
 *
 */


public class AwareTestBean implements ApplicationContextAware, BeanNameAware, NamedBean {

    private ApplicationContext ctx;

    // 当前的bean依赖它本身的name, 需要使用BeanNameAware接口来辅助注入当前bean的name
    private String beanName;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }


    /**
     * NamedBean接口方法
     * @return
     */
    @Override
    public String getBeanName() {
        return beanName;
    }

    /**
     * BeanNameAware接口方法
     */
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }



    public void printBeanNames() {
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
