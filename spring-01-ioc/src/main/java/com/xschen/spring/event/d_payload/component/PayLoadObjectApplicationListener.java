package com.xschen.spring.event.d_payload.component;

import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;

/**
 * @author xschen
 * @see PayloadApplicationEvent  泛型，可监听某个特定类型的payload事件
 */


public class PayLoadObjectApplicationListener implements ApplicationListener<PayloadApplicationEvent> {
    /**
     * PayLoadApplicationEvent本身是有泛型的，如果不指定具体的泛型，会监听所有PayloadApplicationEvent事件
     * @param event
     */
    @Override
    public void onApplicationEvent(PayloadApplicationEvent event) {
        System.out.println("监听到PayLoadApplicationEvent--->" + event.getPayload());
    }
}
