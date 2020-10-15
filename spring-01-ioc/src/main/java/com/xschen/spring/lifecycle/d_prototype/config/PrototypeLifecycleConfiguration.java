package com.xschen.spring.lifecycle.d_prototype.config;

import com.xschen.spring.lifecycle.d_prototype.bean.Pen;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author xschen
 */

@Configuration
public class PrototypeLifecycleConfiguration {

    @Bean(initMethod = "open", destroyMethod = "close")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Pen pen() {
        return new Pen();
    }

}
