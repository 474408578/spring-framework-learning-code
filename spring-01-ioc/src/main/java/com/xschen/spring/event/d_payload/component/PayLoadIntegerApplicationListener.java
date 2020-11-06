package com.xschen.spring.event.d_payload.component;

import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;

/**
 * @author xschen
 */


public class PayLoadIntegerApplicationListener implements ApplicationListener<PayloadApplicationEvent<Integer>> {
    @Override
    public void onApplicationEvent(PayloadApplicationEvent<Integer> event) {
        System.out.println("监听到PayLoadApplicationEvent[Integer]----->" + event.getPayload());
    }
}
