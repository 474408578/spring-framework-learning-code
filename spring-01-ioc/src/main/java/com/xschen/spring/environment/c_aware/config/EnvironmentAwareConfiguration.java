package com.xschen.spring.environment.c_aware.config;

import com.xschen.spring.environment.c_aware.bean.EnvironmentAwareTestBean;
import com.xschen.spring.environment.c_aware.bean.EnvironmentNoAwareTestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
public class EnvironmentAwareConfiguration {
    @Bean
    public EnvironmentAwareTestBean environmentBean() {
        return new EnvironmentAwareTestBean();
    }

    @Bean
    public EnvironmentNoAwareTestBean environmentNoAwareTestBean() {
        return new EnvironmentNoAwareTestBean();
    }
}
