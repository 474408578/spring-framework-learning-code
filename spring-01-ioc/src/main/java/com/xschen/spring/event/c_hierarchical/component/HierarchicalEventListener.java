package com.xschen.spring.event.c_hierarchical.component;

import org.springframework.context.ApplicationListener;

/**
 * @author xschen
 */


public class HierarchicalEventListener implements ApplicationListener<HierarchicalEvent> {
    @Override
    public void onApplicationEvent(HierarchicalEvent hierarchicalEvent) {
        System.out.println("监听到HierarchicalEvent: " + hierarchicalEvent.toString());
    }
}
