package com.think.in.spring.bean.factory;

import com.think.in.spring.ioc.container.overview.domain.User;

/**
 * {@link User} 工厂类
 * @author xschen
 */


public interface UserFactory {
    default User createUser() {
        return User.createUser();
    }
}
