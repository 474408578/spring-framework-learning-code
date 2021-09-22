package com.think.in.spring.configuration.metadata;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * {@link AnnotationMetadata } 示例
 * @author xschen
 * @date 2021/9/22 14:35
 * @see AnnotationMetadata
 * @see StandardAnnotationMetadata
 */

public class StandardAnnotationMetadataDemo {


    public static void main(String[] args) {
        // introspect 接口内的静态方法(Java 8 引入)
        AnnotationMetadata introspect = AnnotationMetadata.introspect(MetaDemo.class);
        System.out.println(introspect.getClassName());
        System.out.println(introspect.getSuperClassName());
        Map<String, Object> classAnnotationAttributes = introspect.getAnnotationAttributes(MyAnnotation.class.getName());
        for (Map.Entry<String, Object> entry : classAnnotationAttributes.entrySet()) {
            System.out.printf("key: %s, value: %s\n", entry.getKey(), entry.getValue());
        }

        // 获取含有注解 MyAnnotation 的方法
        Set<MethodMetadata> methodAnnotationMetadata = introspect.getAnnotatedMethods(MyAnnotation.class.getName());
        methodAnnotationMetadata.stream().map(MethodMetadata::getMethodName).forEach(System.out::println);
    }

    @MyAnnotation(type = "class", isAbstract = true)
    static class MetaDemo extends HashMap<String, String> implements Serializable {

        @MyAnnotation(type = "Method")
        public String getName() {
            return null;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface MyAnnotation {
        String type();
        boolean isAbstract() default false;
    }
}
