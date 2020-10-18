package com.xschen.spring.event.b_registerevent.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author xschen
 * 注册成功的事件, 继承自ApplicationEvent
 */


public class RegisterSuccessEvent extends ApplicationEvent {

    public RegisterSuccessEvent(Object source) {
        super(source);
    }
}
