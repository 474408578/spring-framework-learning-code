package com.xschen.spring.postprocessor.a_quickstart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class BeanPostProcessorQuickStartQpplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.xschen.spring.postprocessor.a_quickstart");

        ctx.close();
    }
}
