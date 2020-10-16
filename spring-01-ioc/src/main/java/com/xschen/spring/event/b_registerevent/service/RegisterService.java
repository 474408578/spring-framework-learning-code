package com.xschen.spring.event.b_registerevent.service;

import com.xschen.spring.event.b_registerevent.event.RegisterSuccessEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author xschen
 * 注册逻辑业务层：只有事件和监听器还不够，还需一个事件源来持有事件发布器，在应用上下文中发布事件
 *
 */

@Service
public class RegisterService implements ApplicationEventPublisherAware {
    // 需要注入ApplicationEventPublisher来发布事件，此处选择使用回调注入
    ApplicationEventPublisher publisher;

    public void register(String username) {
        // 用户注册的动作
        System.out.println(username + "注册成功……");

        // 发布事件
        publisher.publishEvent(new RegisterSuccessEvent(username));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
}
