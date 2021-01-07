package com.think.in.spring.dependency.lookup;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * {@link org.springframework.beans.factory.BeanCreationException} 示例
 * @author xschen
 */


public class BeanCreationExceptionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 BeanDefinition Bean Class 是一个 POJO 普通类，不过初始化方法回调时抛出异常
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(POJO.class);
        AbstractBeanDefinition errorBeanDefinition = beanDefinitionBuilder.getBeanDefinition();
        applicationContext.registerBeanDefinition("errorBean", errorBeanDefinition);

        applicationContext.refresh();
        applicationContext.close();
    }

    static class POJO implements InitializingBean {
//        @PostConstruct
//        public void init() throws Exception {
//            throw new Exception("@PostConstruct: for purposes");
//        }


        @Override
        public void afterPropertiesSet() throws Exception {
            throw new Exception("afterPropertiesSet(): for purposes……");
        }
    }

}
