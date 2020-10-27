package com.xschen.spring.postprocessor.c_executetime;

import com.xschen.spring.postprocessor.c_executetime.bean.Dog;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 *
 * 由此可以总结出 bean 的初始化阶段的全流程：
 * BeanPostProcessor#postProcessBeforeInitialization →
 *  @PostConstruct →
 *      InitializingBean →
 *          init-method →
 *              BeanPostProcessor#postProcessAfterInitialization
 */

@Configuration
public class BeanPostProcessorExecuteTimeApplication {
    @Bean(initMethod = "initMethod")
    public Dog dog() {
        return new Dog();
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("" +
                "com.xschen.spring.postprocessor.c_executetime");
        ctx.close();
    }
}
