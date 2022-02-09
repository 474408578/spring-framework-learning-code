package com.think.in.spring.conversion;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.PropertyEditorRegistrySupport;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * 自定义 {@link PropertyEditorRegistrar} 实现
 * @author xschen
 * @see PropertyEditorRegistrySupport
 */

//@Component // 3. 将其声明为 Spring Bean
public class CustomizedPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        // 1. 通用类型转换
        // 2. Java Bean 属性类型转化
        registry.registerCustomEditor(Properties.class, "context", new StringToPropertiesPropertyEditor());
    }
}
