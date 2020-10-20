package com.xschen.spring.environment.c_aware;

import com.xschen.spring.environment.c_aware.bean.EnvironmentAwareTestBean;
import com.xschen.spring.environment.c_aware.bean.EnvironmentNoAwareTestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class EnvironmentAwareApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                EnvironmentAwareTestBean.class);
        EnvironmentAwareTestBean environmentAwareTestBean = ctx.getBean(EnvironmentAwareTestBean.class);
        environmentAwareTestBean.printEnvironment();

        EnvironmentNoAwareTestBean environmentNoAwareTestBean = ctx.getBean(EnvironmentNoAwareTestBean.class);

        //No qualifying bean of type …… available
        environmentNoAwareTestBean.printEnvironment();
    }
}
