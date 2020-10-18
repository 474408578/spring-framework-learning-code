package com.xschen.spring.configuration.b_profile.config;

import com.xschen.spring.configuration.b_profile.component.Bar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
public class BarConfiguration {
    @Bean
    public Bar bar() {
        return new Bar();
    }
}
