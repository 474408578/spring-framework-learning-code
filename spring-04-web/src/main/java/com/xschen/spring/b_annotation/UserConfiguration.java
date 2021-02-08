package com.xschen.spring.b_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
public class UserConfiguration {

    @Bean
    public UserService userService() {
        return new UserService();
    }
}
