package com.think.in.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@link PayloadApplicationEvent} 使用示例
 * @author xschen
 */


public class PayloadApplicationEventDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(PayloadApplicationEventDemo.class);

        context.refresh();

        // 注册监听器
        context.addApplicationListener(new MyPayloadIntegerApplicationListener());
        context.addApplicationListener(new MyPayloadObjectApplicationListener());
        // 发布事件
        context.publishEvent(123);
        context.publishEvent(new Object());

        context.close();
    }

    static class MyPayloadIntegerApplicationListener implements ApplicationListener<PayloadApplicationEvent<Integer>> {
        @Override
        public void onApplicationEvent(PayloadApplicationEvent<Integer> event) {
            System.out.println("监听到PayloadApplicationEvent<Integer> --->" + event.getPayload());
        }
    }

    static class MyPayloadObjectApplicationListener implements ApplicationListener<PayloadApplicationEvent> {
        @Override
        public void onApplicationEvent(PayloadApplicationEvent event) {
            System.out.println("监听到PayloadApplicationListener<Object> --->" + event.getPayload());
        }
    }
}
