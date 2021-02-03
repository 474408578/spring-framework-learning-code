package com.think.in.spring.bean.lifecycle;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean Class 加载示例
 * @author xschen
 *
 * @see BeanDefinition#getBeanClassName()
 * @see AbstractBeanFactory#resolveBeanClass(RootBeanDefinition, String, Class[])
 * @see ClassLoader#loadClass(String)
 * @see Thread#getContextClassLoader() 
 *
 */
public class BeanClassLoaderDemo {
}