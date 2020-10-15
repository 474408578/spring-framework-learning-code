package com.xschen.spring.lifecycle.a_initmethod;

import com.xschen.spring.lifecycle.a_initmethod.config.InitMethodConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class InitMethodAnnoApplication {
    public static void main(String[] args) {
        System.out.println("准备初始化IOC容器……");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(InitMethodConfiguration.class);
        System.out.println("IOC容器初始化完成……\n");

        System.out.println("准备销毁IOC容器……");
        ctx.close();
        System.out.println("IOC容器销毁完成……");
    }
}
