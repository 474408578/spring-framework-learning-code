package com.xschen.spring.event.b_registerevent.listener;

import com.xschen.spring.event.b_registerevent.event.RegisterSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
public class EmailSenderListener implements ApplicationListener<RegisterSuccessEvent> {
    @Override
    public void onApplicationEvent(RegisterSuccessEvent event) {
        System.out.println("监听到用户注册成功，发送邮件中……");
    }
}
