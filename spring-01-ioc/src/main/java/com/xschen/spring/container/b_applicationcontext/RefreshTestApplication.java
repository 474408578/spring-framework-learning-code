package com.xschen.spring.container.b_applicationcontext;

import com.xschen.spring.container.b_applicationcontext.config.CatConfiguration;
import com.xschen.spring.container.b_applicationcontext.config.DogConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @author xschen
 */


public class RefreshTestApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(CatConfiguration.class);
        ctx.refresh();

        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);

        ctx.register(DogConfiguration.class);
        // 此处会抛出重复刷新异常
        ctx.refresh();

        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
