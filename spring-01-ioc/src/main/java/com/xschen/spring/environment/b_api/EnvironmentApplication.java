package com.xschen.spring.environment.b_api;

import com.xschen.spring.environment.b_api.bean.EnvironmentHolder;
import com.xschen.spring.environment.b_api.config.EnvironmentPropertyConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class EnvironmentApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                EnvironmentPropertyConfiguration.class);
        EnvironmentHolder environmentHolder = ctx.getBean(EnvironmentHolder.class);
        environmentHolder.printEnvironment();
    }
}
