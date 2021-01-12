package com.think.in.spring.dependency.injection.config;

import com.think.in.spring.dependency.injection.annotation.UserGroup;
import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean注入配置类
 * @author xschen
 */

@Configuration
public class QualifierConfiguration {
    @Bean
    @Qualifier
    // 进行逻辑分组
    public User user1() {
        return createUser(7L);
    }

    @Bean
    @Qualifier // 进行逻辑分组
    public User user2() {
        return createUser(8L);
    }

    @Bean
    @UserGroup
    public User user3() {
        return createUser(9L);
    }

    @Bean
    @UserGroup
    public User user4() {
        return createUser(10L);
    }

    public static User createUser(Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }
}
