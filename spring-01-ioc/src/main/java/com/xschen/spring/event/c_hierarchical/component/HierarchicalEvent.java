package com.xschen.spring.event.c_hierarchical.component;

import org.springframework.context.ApplicationEvent;

/**
 * @author xschen
 */


public class HierarchicalEvent extends ApplicationEvent {
    public HierarchicalEvent(Object source) {
        super(source);
    }
}
