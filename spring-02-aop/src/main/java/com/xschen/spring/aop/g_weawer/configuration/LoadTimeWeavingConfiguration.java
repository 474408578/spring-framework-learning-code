package com.xschen.spring.aop.g_weawer.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

/**
 * @author xschen
 */

@Configuration
@ComponentScan(value = "com.xschen.spring.aop.g_weawer")
//@EnableAspectJAutoProxy // 启用 运行时创建对象织入
@EnableLoadTimeWeaving // 启用 类加载时期织入
public class LoadTimeWeavingConfiguration {
}
