package com.think.in.spring.bean.lifecycle;

import com.think.in.spring.ioc.container.overview.domain.User;

/**
 * @author xschen
 */
public class UserHolder {
    private final User user;

    public UserHolder(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
