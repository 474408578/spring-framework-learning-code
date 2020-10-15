package com.xschen.spring.lifecycle.c_initializingbean.config;

import com.xschen.spring.lifecycle.c_initializingbean.bean.Pen3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
@ComponentScan("com.xschen.spring.lifecycle.c_initializingbean.bean")
public class InitializingDisposableConfiguration {
    @Bean(initMethod = "open", destroyMethod = "close")
    public Pen3 pen3() {
        return new Pen3();
    }
}
