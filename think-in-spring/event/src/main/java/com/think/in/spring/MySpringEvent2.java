package com.think.in.spring;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义 Spring事件 示例
 * @author xschen
 */


public class MySpringEvent2 extends MySpringEvent {
    public MySpringEvent2(Object message) {
        super(message);
    }

    @Override
    public String getSource() {
        return (String) super.getSource();
    }

    public String getMessage(){
        return getSource();
    }
}
