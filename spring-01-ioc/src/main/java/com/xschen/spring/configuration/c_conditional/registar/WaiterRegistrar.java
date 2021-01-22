package com.xschen.spring.configuration.c_conditional.registar;

import com.xschen.spring.configuration.c_conditional.component.Bar;
import com.xschen.spring.configuration.c_conditional.config.BarConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xschen
 */


public class WaiterRegistrar implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[] {Bar.class.getName(), BarConfiguration.class.getName()};
    }
}
