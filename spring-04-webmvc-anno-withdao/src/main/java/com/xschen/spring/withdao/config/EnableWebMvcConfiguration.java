package com.xschen.spring.withdao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 第二种写法 @EnableWebMvc
 * @author xschen
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "com.xschen.spring.withdao",
        includeFilters = @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION),
        useDefaultFilters = false)
public class EnableWebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/pages/", ".jsp");
    }
}
