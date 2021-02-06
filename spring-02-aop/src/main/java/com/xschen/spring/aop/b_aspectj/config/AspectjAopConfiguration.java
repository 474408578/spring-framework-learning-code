package com.xschen.spring.aop.b_aspectj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xschen
 */

@Configuration
@ComponentScan("com.xschen.spring.aop.b_aspectj")
@EnableAspectJAutoProxy // 开启AOP自动代理（模块装配 + 条件装配）
public class AspectjAopConfiguration {
}
