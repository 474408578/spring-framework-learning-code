package com.xschen.spring.aop.e_aopcontext.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xschen
 */

@EnableAspectJAutoProxy(exposeProxy = true) // 暴露代理对象
@Configuration
@ComponentScan("com.xschen.spring.aop.e_aopcontext")
public class AopContextConfiguration {
}
