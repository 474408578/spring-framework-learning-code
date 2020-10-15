package com.xschen.spring.lifecycle.b_jsr250.config;

import com.xschen.spring.lifecycle.b_jsr250.bean.Pen2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
@ComponentScan("com.xschen.spring.lifecycle.b_jsr250.bean")
public class JSR250Configuration {

    @Bean(initMethod = "open", destroyMethod = "close")
    public Pen2 pen2() {
        return new Pen2();
    }
}
