package com.xschen.spring.event.b_registerevent;

import com.xschen.spring.event.b_registerevent.service.RegisterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class RegisterEventApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.xschen.spring.event.b_registerevent");

        RegisterService registerService = ctx.getBean(RegisterService.class);
        registerService.register("xiangsong");
    }
}
