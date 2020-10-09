package com.xschen.spring.basic_dl.d_withanno.anno;

import java.lang.annotation.*;

/**
 * @author xschen
 */

@Documented // 用于指定被该元注解修饰的注解类将被Javadoc工具提取成文档
@Retention(RetentionPolicy.RUNTIME) // 指定被修饰的注解可以保留多长时间
@Target(ElementType.TYPE) // 指定这个策略的注解可以修饰类，接口（包括注解类型）或枚举定义
public @interface Color {

}
