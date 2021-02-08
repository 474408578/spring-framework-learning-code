package com.xschen.spring.aop.d_order.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xschen
 */

@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.xschen.spring.aop.d_order")
public class AspectOrderConfiguration {

}
