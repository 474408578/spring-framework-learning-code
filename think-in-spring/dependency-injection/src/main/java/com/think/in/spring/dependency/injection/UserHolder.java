package com.think.in.spring.dependency.injection;

import com.think.in.spring.ioc.container.overview.domain.User;

/**
 * {@link User} 的Holder类
 * @author xschen
 */


public class UserHolder {
    private User user;

    public UserHolder(User user) {
        this.user = user;
    }

    public UserHolder() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
