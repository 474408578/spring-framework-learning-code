package com.xschen.spring.configuration.a_module.selector;

import com.xschen.spring.configuration.a_module.component.Bar;
import com.xschen.spring.configuration.a_module.config.BarConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * @author xschen
 *
 * BarImportSelector本身不会注册到IOC容器
 *
 * ImportSelector可以根据筛选标准来指定导入哪些配置类
 */


public class BarImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[] {/*Bar.class.getName(),*/ BarConfiguration.class.getName()};
    }

//    @Override
//    public Predicate<String> getExclusionFilter() {
//        return null;
//    }
}
