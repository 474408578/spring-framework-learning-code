package com.xschen.spring.postprocessor.b_getproperty;

import com.xschen.spring.postprocessor.b_getproperty.bean.Cat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class PostProcessorGetPropertyApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.xschen.spring.postprocessor.b_getproperty");
        ctx.close();

        /**
         * 引用类型传递的是地址
        Cat cat = new Cat();
        Cat cat1 = cat;
        cat1.setName("124");
        System.out.println(cat.toString()); // 124
         */
    }
}
