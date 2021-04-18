package com.xschen.spring.aop.g_weawer;

import com.xschen.spring.aop.g_weawer.configuration.LoadTimeWeavingConfiguration;
import com.xschen.spring.aop.g_weawer.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 类加载时期织入
 * @author xschen
 * FIXME 运行失败
 */

public class LoadTimeWeavingApplication {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LoadTimeWeavingConfiguration.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.get("aaa");
    }
}
