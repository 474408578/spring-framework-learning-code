package com.xschen.spring.basic_di.g_complexfield;

import com.xschen.spring.basic_di.g_complexfield.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 复杂类型注入xml示例
 * @author xschen
 */


public class ComplexFieldXmlApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basic_di/complexfield/inject-complexfield.xml");
        Person person = ctx.getBean(Person.class);
        System.out.println(person);
    }
}
