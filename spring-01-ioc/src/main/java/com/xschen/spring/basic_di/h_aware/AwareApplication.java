package com.xschen.spring.basic_di.h_aware;

import com.xschen.spring.basic_di.h_aware.bean.AwareTestBean;
import com.xschen.spring.basic_di.h_aware.config.AwareConfigutation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class AwareApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AwareConfigutation.class);
        AwareTestBean bbb = ctx.getBean(AwareTestBean.class);
        bbb.printBeanNames();
        System.out.println("----------------------------");
        System.out.println(bbb.getBeanName());
    }
}
