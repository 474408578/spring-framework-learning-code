package com.xschen.spring.postprocessor.i_registerprocessor;

import com.xschen.spring.postprocessor.i_registerprocessor.bean.Cat;
import com.xschen.spring.postprocessor.i_registerprocessor.bean.Dog;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 *
 * BeanDefinitionRegistryPostProcessor的postProcessBeanDefinitionRegistry执行完毕后，
 * 执行他的postProcessBeanFactory, 然后执行普通的BeanFactoryPostProcessor
 */


public class RegistryPostProcessorApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.xschen.spring.postprocessor.i_registerprocessor");
        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);

        Dog dog = ctx.getBean(Dog.class);
        System.out.println(dog);
    }
}
