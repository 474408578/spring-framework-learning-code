package com.think.in.spring.bean.scope.web;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author xschen
 */

@Configuration
@EnableWebMvc
public class WebConfiguration {

    @Bean
    @ApplicationScope
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("xschen");
        return user;
    }
}
