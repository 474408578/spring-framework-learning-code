package com.think.in.spring.aop.feature;

import com.think.in.spring.aop.overview.EchoService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link ProxyFactoryBean} 示例
 * @author xschen
 * @date 2021/9/20 12:05
 * @see ProxyFactoryBean
 */

public class ProxyFactoryBeanDemo {

    public static void main(String[] args) throws Throwable {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring-aop-context.xml");

        EchoService echoService = context.getBean("echoServiceProxyFactoryBean", EchoService.class);
        System.out.println(echoService.echo("Hello World"));
        context.close();
    }
}
