package com.xschen.spring.annotation.e_basepackageclass.config;

import com.xschen.spring.annotation.e_basepackageclass.bean.DemoService;
import com.xschen.spring.annotation.e_basepackageclass.component.DemoComponent;
import com.xschen.spring.annotation.e_basepackageclass.component.inner.InnerComponent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
@ComponentScan(basePackageClasses = {DemoService.class, InnerComponent.class})
public class BasePackageClassConfiguration {
}
