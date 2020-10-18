package com.xschen.spring.annotation.f_typefilter.config;

import com.xschen.spring.annotation.f_typefilter.anno.Animal;
import com.xschen.spring.annotation.f_typefilter.color.Color;
import com.xschen.spring.annotation.f_typefilter.filter.GreenTypeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author xschen
 */

@Configuration
@ComponentScan(basePackages = "com.xschen.spring.annotation.f_typefilter",
        includeFilters = {
                // 使用正则表达式
                @ComponentScan.Filter(type = FilterType.REGEX,
                        pattern = "com.xschen.spring.annotation.f_typefilter.+Demo.+"),
        },
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Animal.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Color.class),
                @ComponentScan.Filter(type = FilterType.CUSTOM, value = GreenTypeFilter.class)
        })
public class TypeFilterConfiguration {

}
