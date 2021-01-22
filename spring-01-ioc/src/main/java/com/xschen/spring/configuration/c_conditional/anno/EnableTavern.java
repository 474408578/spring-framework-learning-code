package com.xschen.spring.configuration.c_conditional.anno;

import com.xschen.spring.configuration.c_conditional.component.Boss;
import com.xschen.spring.configuration.c_conditional.config.BartenderConfiguration;
import com.xschen.spring.configuration.c_conditional.registar.WaiterRegistrar;
import com.xschen.spring.configuration.c_conditional.selector.BarImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author xschen
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({
        Boss.class,
        BartenderConfiguration.class,
        WaiterRegistrar.class,
        BarImportSelector.class
})
public @interface EnableTavern {
}
