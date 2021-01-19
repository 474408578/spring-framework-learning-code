package com.xschen.spring.configuration.a_module.registar;

import com.xschen.spring.configuration.a_module.component.Waiter;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xschen
 * ImportBeanDefinitionRegistrar: 编程式向IOC容器导入Bean
 * WaiterRegistar本身不会注入到IOC容器中
 */


public class WaiterRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata,
                                        BeanDefinitionRegistry registry) {
        registry.registerBeanDefinition("waiter", new RootBeanDefinition(Waiter.class));
    }
}
