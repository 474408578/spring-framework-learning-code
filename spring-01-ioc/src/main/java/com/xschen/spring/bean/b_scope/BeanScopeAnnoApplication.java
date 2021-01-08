package com.xschen.spring.bean.b_scope;

import com.xschen.spring.bean.b_scope.bean.Child;
import com.xschen.spring.bean.b_scope.config.BeanScopeConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 演示Bean的作用域
 * @author xschen
 */


public class BeanScopeAnnoApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanScopeConfiguration.class);
        // 两个child持有同一个toy
        ctx.getBeansOfType(Child.class).forEach((name, child) -> {
            System.out.println(name + ": " + child);
        });
    }
}
