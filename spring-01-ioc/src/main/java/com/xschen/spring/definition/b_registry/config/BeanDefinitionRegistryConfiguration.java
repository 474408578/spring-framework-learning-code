package com.xschen.spring.definition.b_registry.config;

import com.xschen.spring.definition.b_registry.registar.PersonRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 配置类，导入PersonRegistrar
 * @author xschen
 */

@Configuration
@Import(PersonRegistrar.class)
public class BeanDefinitionRegistryConfiguration {

}
