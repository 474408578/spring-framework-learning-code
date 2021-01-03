package com.think.in.spring.bean.factory;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@User} Bean的 {@link org.springframework.beans.factory.FactoryBean} 实现
 * @author xschen
 */


public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
