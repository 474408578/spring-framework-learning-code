package com.xschen.spring.basic_dl.c_oftype;

import com.xschen.spring.basic_dl.c_oftype.dao.DemoDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author xschen
 *
 * 如果一个接口有多种属性，如何一次取出来
 * 将Beanfactory修改为ApplicationContext接口
 *
 * BeanFactory 接口提供了一个抽象的配置和对象的管理机制，
 * ApplicationContext 是 BeanFactory 的子接口，
 * 它简化了与 AOP 的整合、消息机制、事件机制，以及对 Web 环境的扩展（ WebApplicationContext 等），
 * BeanFactory 是没有这些扩展的。
 *
 * ApplicationContext 主要扩展了以下功能
 *   AOP 的支持（ AnnotationAwareAspectJAutoProxyCreator 作用于 Bean 的初始化之后 ）
 *   配置元信息（ BeanDefinition 、Environment 、注解等 ）
 *   资源管理（ Resource 抽象 ）
 *   事件驱动机制（ ApplicationEvent 、ApplicationListener ）
 *   消息与国际化（ LocaleResolver ）
 *   Environment 抽象（ SpringFramework 3.1 以后）
 *
 * ApplicationContext 主要扩展了以下功能：
 *
 */


public class OfTypeApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basic_dl/quickstart-oftype.xml");
        Map<String, DemoDao> beans = ctx.getBeansOfType(DemoDao.class);

        beans.forEach((beanName, bean) -> {
            System.out.println(beanName + " : " + bean.toString());
        });
    }
}
