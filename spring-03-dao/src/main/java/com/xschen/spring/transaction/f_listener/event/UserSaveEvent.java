package com.xschen.spring.transaction.f_listener.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义发布事件
 * @author xschen
 */


public class UserSaveEvent extends ApplicationEvent {

    public UserSaveEvent(Object source) {
        super(source);
    }
}
