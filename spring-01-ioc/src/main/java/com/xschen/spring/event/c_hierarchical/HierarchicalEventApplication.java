package com.xschen.spring.event.c_hierarchical;

import com.xschen.spring.event.c_hierarchical.component.HierarchicalEvent;
import com.xschen.spring.event.c_hierarchical.component.HierarchicalEventListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class HierarchicalEventApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext parentCtx = new AnnotationConfigApplicationContext();
        parentCtx.addApplicationListener(new HierarchicalEventListener());

        AnnotationConfigApplicationContext childCtx = new AnnotationConfigApplicationContext();
        childCtx.addApplicationListener(new HierarchicalEventListener());
        childCtx.setParent(parentCtx);

        /**
         * 先刷新父容器。在刷新子容器
         */
        parentCtx.refresh();
        childCtx.refresh();

        parentCtx.publishEvent(new HierarchicalEvent("父容器发布的HierarchicalEvent"));
        childCtx.publishEvent(new HierarchicalEvent("子容器发布的HierarchicalEvent"));
    }
}
