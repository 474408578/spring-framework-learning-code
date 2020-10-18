package com.xschen.spring.configuration.c_conditional.config;

import com.xschen.spring.configuration.c_conditional.anno.ConditionalOnBean;
import com.xschen.spring.configuration.c_conditional.component.Bar;
import com.xschen.spring.configuration.c_conditional.component.Boss;
import com.xschen.spring.configuration.c_conditional.condition.ExistBossCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
public class BarConfiguration {
    @Bean
//    @Conditional(ExistBossCondition.class) // Bar的创建需要Boss的存在
    // 使用全限定类名
//    @ConditionalOnBean(beanNames = "com.xschen.spring.configuration.c_conditional.component.Boss")
    // 使用类字节码
    @ConditionalOnBean(Boss.class)
    public Bar bbbar() {
        return new Bar();
    }
}
