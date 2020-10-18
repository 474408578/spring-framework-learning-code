package com.xschen.spring.configuration.b_profile.registar;

import com.xschen.spring.configuration.b_profile.component.Bar;
import com.xschen.spring.configuration.b_profile.config.BarConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xschen
 */


public class WaiterRegistar implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[] {Bar.class.getName(), BarConfiguration.class.getName()};
    }
}
