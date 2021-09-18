package com.xschen.spring.event.b_registerevent;

import com.xschen.spring.event.b_registerevent.service.RegisterService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.util.ErrorHandler;

import java.util.concurrent.Executor;

/**
 * @author xschen
 * @see ApplicationEventMulticaster#multicastEvent(ApplicationEvent)  
 * @see ApplicationEventPublisher#publishEvent(Object)
 * @see SimpleApplicationEventMulticaster#setTaskExecutor(Executor) 
 * @see SimpleApplicationEventMulticaster#setErrorHandler(ErrorHandler)
 */


public class RegisterEventApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.xschen.spring.event.b_registerevent");

        RegisterService registerService = ctx.getBean(RegisterService.class);
        registerService.register("xiangsong");
    }
}
