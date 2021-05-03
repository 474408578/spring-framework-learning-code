package com.xschen.spring.withdao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * 第一种写法，直接注册 ViewResolver
 * @author xschen
 */

@Configuration
@ComponentScan(value = "com.xschen.spring.withdao",
        includeFilters = @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION),
        useDefaultFilters = false) // 禁用默认的扫描规则
public class WebMvcConfiguration {

    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
