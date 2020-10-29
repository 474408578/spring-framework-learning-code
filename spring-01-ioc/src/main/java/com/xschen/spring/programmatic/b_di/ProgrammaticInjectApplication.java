package com.xschen.spring.programmatic.b_di;

import com.xschen.spring.programmatic.b_di.bean.Cat;
import com.xschen.spring.programmatic.b_di.bean.Dog;
import com.xschen.spring.programmatic.b_di.bean.Person;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class ProgrammaticInjectApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        BeanDefinition personDefinition = BeanDefinitionBuilder.rootBeanDefinition(Person.class)
                .addPropertyValue("name", "老王")
                .getBeanDefinition();
        ctx.registerBeanDefinition("laowang", personDefinition);

        BeanDefinition catDefinition = BeanDefinitionBuilder.rootBeanDefinition(Cat.class)
                .addPropertyReference("person", "laowang")
                .addPropertyValue("name", "咪咪")
                .getBeanDefinition();
        ctx.registerBeanDefinition("mimi", catDefinition);

//        BeanDefinition dogDefinition = BeanDefinitionBuilder.rootBeanDefinition(Dog.class)
//                .addPropertyValue("name", "汪汪")
//                .addPropertyReference("person", "laowang")
//                .setScope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//                .getBeanDefinition();
//        ctx.registerBeanDefinition("wangwang", dogDefinition);

        BeanDefinition lazyDogDefinition = BeanDefinitionBuilder.rootBeanDefinition(Dog.class)
                .addPropertyReference("person", "laowang")
                .addPropertyValue("name", "lazywangwang")
                .setLazyInit(true)
                .getBeanDefinition();
        ctx.registerBeanDefinition("lazywangwang", lazyDogDefinition);


        // refresh会触发bean的实例化
        ctx.refresh();

        System.out.println("ApplicationContext refreshed ……");
        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);

        Dog dog = ctx.getBean(Dog.class);
        System.out.println(dog);



    }
}
