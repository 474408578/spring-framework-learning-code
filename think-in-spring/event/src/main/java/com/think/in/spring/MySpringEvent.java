package com.think.in.spring;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义 Spring事件 示例
 * @author xschen
 */


public class MySpringEvent extends ApplicationEvent {
    public MySpringEvent(Object message) {
        super(message);
    }

    @Override
    public String getSource() {
        return (String) super.getSource();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
