package com.xschen.spring.basic_di.f_jsr330;

import com.xschen.spring.basic_di.f_jsr330.bean.Cat;
import com.xschen.spring.basic_di.f_jsr330.config.JSR330Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 *
 * JSR330-@Inject 需要导入依赖javax.inject
 *
 * 注解	        注入方式	        是否支持@Primary    	来源              	    Bean不存在时处理
 * @Autowired   根据类型注入           是	    SpringFramework原生注解	    可指定required=false来避免注入失败
 * @Resource    根据名称注入           是	    JSR250规范	                容器中不存在指定Bean会抛出异常
 * @Inject      根据类型注入           是	    JSR330规范 ( 需要导jar包 )	容器中不存在指定Bean会抛出异常
 */


public class JSR330Application {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(JSR330Configuration.class);
        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);
    }
}
