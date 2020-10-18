package com.xschen.spring.configuration.a_module.anno;

import com.xschen.spring.configuration.a_module.component.Boss;
import com.xschen.spring.configuration.a_module.config.BartenderConfiguration;
import com.xschen.spring.configuration.a_module.registar.WaiterRegistar;
import com.xschen.spring.configuration.a_module.selector.BarImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author xschen
 * todo: import的四种导入方式: 普通类，配置类，ImportSelector， ImportBeanDefinitionRegistar
 * 通过一个注解，一次性导入需要的组件及配置
 *
 * 如果标注了@EnableTavern注解，就会触发@Import的效果，
 * 向容器中导入一个Boss类型的Bean.
 *
 * 导入普通类，导入配置类
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// @Import可以导入配置类，ImportSelector的实现类，
// ImportBeanDefinitionRegister的实现类，或者普通类。
@Import({Boss.class,
        BartenderConfiguration.class,
        BarImportSelector.class,
        WaiterRegistar.class})
public @interface EnableTavern {
}
