package com.xschen.spring.definition.b_registry.config;

import com.xschen.spring.definition.b_registry.registar.PersonRegistar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xschen
 */

@Configuration
@Import(PersonRegistar.class)
public class BeanDefinitionRegistryConfiguration {

}
