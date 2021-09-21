package com.think.in.spring.aop.feature;

import com.think.in.spring.aop.overview.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于 Xml 形式的 Aspect 示例
 * @author xschen
 * @date 2021/9/20 18:54
 */

public class AspectJSchemaBasedPointcutDemo {

    public static void main(String[] args) throws Throwable {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring-aop-context.xml");
        EchoService echoService = context.getBean("echoService", EchoService.class);
        System.out.println(echoService.echo("Hello World"));

        context.close();
    }
}
