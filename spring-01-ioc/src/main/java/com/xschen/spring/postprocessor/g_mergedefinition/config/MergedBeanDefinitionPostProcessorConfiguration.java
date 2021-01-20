package com.xschen.spring.postprocessor.g_mergedefinition.config;

import com.xschen.spring.postprocessor.g_mergedefinition.bean.Cat;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * {@link MergedBeanDefinitionPostProcessor#postProcessMergedBeanDefinition(RootBeanDefinition, Class, String)} 示例
 * 方法发生在Bean的实例化之后，自动注入之前
 * @author xschen
 */

@Component
public class MergedBeanDefinitionPostProcessorConfiguration implements MergedBeanDefinitionPostProcessor {
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition,
                                                Class<?> beanType,
                                                String beanName) {
        if (Cat.class.equals(beanType)) {
            System.out.println("MergeDefinitionPostProcessor postProcessMergedBeanDefinition run ……");
            System.out.println(beanDefinition);
        }

    }
}
