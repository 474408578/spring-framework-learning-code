package com.xschen.spring.event.b_registerevent.listener;

import com.xschen.spring.event.b_registerevent.event.RegisterSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
public class MessageSenderListener {
    @EventListener
    @Order() // 使用@Order注解，可以调整监听器的触发顺序
    public void onRegisterSucess(RegisterSuccessEvent event) {
        System.out.println("监听到用户注册成功，发送站内信……");
    }
}
