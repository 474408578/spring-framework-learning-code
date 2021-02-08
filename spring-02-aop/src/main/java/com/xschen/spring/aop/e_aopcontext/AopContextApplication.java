package com.xschen.spring.aop.e_aopcontext;

import com.xschen.spring.aop.e_aopcontext.config.AopContextConfiguration;
import com.xschen.spring.aop.e_aopcontext.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Target对象调用自身的方法也需要AOP的增强 演示
 * @author xschen
 */


public class AopContextApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopContextConfiguration.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.update("abc", "def");
    }
}
