package com.think.in.spring.annotation;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 跨注解的属性别名
 * @author xschen
 * @date 2021/12/16 10:05
 * @see org.springframework.core.annotation.AnnotationAttributes
 */

@Service("serviceAlias")
public class AliasDemo {

    public static void main(String[] args) {
        Service service = AnnotationUtils.getAnnotation(AliasDemo.class, Service.class);
        System.out.println(service.value()); // serviceAlias

        // Component 是 Service 父注解
        Component component = AnnotationUtils.getAnnotation(AliasDemo.class, Component.class);
        System.out.println(component.value()); // ""


        // 将@Service#value 值赋给 @Component#value
        Component mergeAnno = AnnotatedElementUtils.getMergedAnnotation(AliasDemo.class, Component.class);
        System.out.println(mergeAnno.value()); // serviceAlias
    }
}
