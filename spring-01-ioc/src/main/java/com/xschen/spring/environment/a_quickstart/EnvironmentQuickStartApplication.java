package com.xschen.spring.environment.a_quickstart;

import com.xschen.spring.environment.a_quickstart.bean.EnvironmentHolder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class EnvironmentQuickStartApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.xschen.spring.environment.a_quickstart.bean");
        EnvironmentHolder environmentHolder = ctx.getBean(EnvironmentHolder.class);
        environmentHolder.printEnvironment();
    }
}
