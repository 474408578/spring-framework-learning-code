package com.xschen.spring.basic_di.b_constructor;

import com.xschen.spring.basic_di.b_constructor.bean.Cat;
import com.xschen.spring.basic_di.b_constructor.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xschen
 */


public class InjectByConstructorXmlApplication {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("basic_di/inject-constructor.xml");
        Person person = ctx.getBean(Person.class);
        System.out.println(person);

        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);
    }
}
