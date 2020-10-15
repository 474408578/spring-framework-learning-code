package com.xschen.spring.lifecycle.c_initializingbean;

import com.xschen.spring.lifecycle.c_initializingbean.config.InitializingDisposableConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 * todo:  @PostContruct --> InitializingBean --> init-method
 */


public class InitializingDisposableAnnoApplication {
    public static void main(String[] args) {
        System.out.println("准备初始化IOC容器……");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(InitializingDisposableConfiguration.class);
        System.out.println("IOC容器初始化完成……");


        System.out.println("准备销毁IOC容器……");
        ctx.close();
        System.out.println("IOC容器销毁完成……");

        /**
         * 准备初始化IOC容器……
         * construct - 买了一支钢笔
         * @PostConstruct - 已加满墨水……
         * InitializingBean - 准备写字……
         * init-method - 打开钢笔……
         * IOC容器初始化完成……
         * 准备销毁IOC容器……
         * @PreDestroy - 钢笔中的墨水都放干净了……
         * DisposableBean - 写完字了……
         * destroy-method - 合上钢笔……
         * IOC容器销毁完成……
         */
    }
}
