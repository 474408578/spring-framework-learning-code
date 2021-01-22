package com.xschen.spring.configuration.b_profile.anno;

import com.xschen.spring.configuration.b_profile.component.Boss;
import com.xschen.spring.configuration.b_profile.config.BartenderConfiguration;
import com.xschen.spring.configuration.b_profile.registar.WaiterRegistrar;
import com.xschen.spring.configuration.b_profile.selector.BarImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author xschen
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({Boss.class,
        BartenderConfiguration.class,
        WaiterRegistrar.class,
        BarImportSelector.class
})
public @interface EnableTavern {
}
