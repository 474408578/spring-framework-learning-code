package com.xschen.spring.postprocessor.g_mergedefinition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */

public class MergeDefinitionPostProcessorApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.xschen.spring.postprocessor.g_mergedefinition");
        ctx.close();
    }
}
