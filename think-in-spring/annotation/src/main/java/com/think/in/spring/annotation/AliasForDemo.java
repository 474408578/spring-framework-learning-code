package com.think.in.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * 一个注解中的两个属性互为别名
 * @author xschen
 * @date 2021/12/16 9:56
 * @see ComponentScan
 */

@ComponentScan("com.think.in.spring.annotation")
public class AliasForDemo {

    public static void main(String[] args) {
        ComponentScan anno = AnnotationUtils.getAnnotation(AliasForDemo.class, ComponentScan.class);
        System.out.println(anno.value()[0]); // com.think.in.spring.annotation
        System.out.println(anno.basePackages()[0]); // com.think.in.spring.annotation
    }

}
