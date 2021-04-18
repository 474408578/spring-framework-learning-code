package com.xschen.spring.aop.f_introduction.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xschen
 */

@Configuration
@ComponentScan(value = "com.xschen.spring.aop.f_introduction")
@EnableAspectJAutoProxy
public class IntroductionConfiguration {
}
