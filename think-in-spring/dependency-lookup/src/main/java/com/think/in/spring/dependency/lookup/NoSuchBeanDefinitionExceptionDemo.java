package com.think.in.spring.dependency.lookup;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * {@link org.springframework.beans.factory.NoSuchBeanDefinitionException} 示例
 * @author xschen
 */


public class NoSuchBeanDefinitionExceptionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(NoSuchBeanDefinitionExceptionDemo.class);
        applicationContext.refresh();
        try {
            // 由于 Spring 应用上下文存在3个 String 类型的 Bean，通过单一类型查找会抛出异常
            applicationContext.getBean(String.class);
        } catch (NoSuchBeanDefinitionException e) {
            System.err.printf("Spring应用上下文中存在%d个%s类型的bean, 具体原因: %s",
                    e.getNumberOfBeansFound(),
                    e.getBeanType(),
                    e.getMessage());
        }

        applicationContext.close();
    }

    @Bean
    public String bean1() {
        return "1";
    }

    @Bean
    public String bean2() {
        return "2";
    }

    @Bean
    public String bean3() {
        return "3";
    }
}
