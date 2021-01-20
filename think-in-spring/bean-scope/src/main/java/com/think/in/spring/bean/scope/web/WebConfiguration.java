package com.think.in.spring.bean.scope.web;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Web MVC 配置类
 * @author xschen
 */

@Configuration
@EnableWebMvc // 激活Spring MVC
public class WebConfiguration {

    @Bean
//    @RequestScope // 作用域
    @ApplicationScope
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("xschen");
        return user;
    }
}
