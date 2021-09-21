package com.think.in.spring.aop.feature;

import com.think.in.spring.aop.overview.EchoService;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于 XML 的自动代理 示例
 * @author xschen
 * @date 2021/9/21 18:20
 * @see BeanNameAutoProxyCreator
 * @see DefaultAdvisorAutoProxyCreator
 */

public class AspectJSchemaBaseAutoProxyDemo {

    public static void main(String[] args) throws Throwable {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring-aop-auto-proxy-context.xml");

        EchoService echoService = context.getBean(EchoService.class);
        System.out.println(echoService.echo("Hello world"));
        context.close();

    }
}
