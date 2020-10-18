package com.xschen.spring.configuration.b_profile.config;

import com.xschen.spring.configuration.b_profile.component.Bartender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author xschen
 */

@Configuration
@Profile("city") // 默认情况下@Profile("default")
public class BartenderConfiguration {

    @Bean
    public Bartender zhangxiaosan() {
        return new Bartender("zhangxiaosan");
    }

    @Bean
    public Bartender zhangdasan() {
        return new Bartender("zhangdasan");
    }
}
