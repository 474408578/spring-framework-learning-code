package com.xschen.spring.basic_di.a_quickstart_set;

import com.xschen.spring.basic_di.a_quickstart_set.bean.Cat;
import com.xschen.spring.basic_di.a_quickstart_set.bean.Person;
import com.xschen.spring.basic_di.a_quickstart_set.config.QuickStartInjectBySetConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 * todo：基于注解的依赖注入
 */


public class QuickStartInjectBySetAnnoApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(QuickStartInjectBySetConfiguration.class);
        Person person = ctx.getBean(Person.class);
        System.out.println(person);

        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);

    }
}
