package com.xschen.spring.basic_di.h_aware.config;

import com.xschen.spring.basic_di.h_aware.bean.AwareTestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
@ComponentScan("com.xschen.spring.basic_di.h_aware.bean")
public class AwareConfigutation {

    @Bean
    public AwareTestBean bbb() {
        return new AwareTestBean();
    }
}
