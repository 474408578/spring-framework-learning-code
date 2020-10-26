package com.xschen.spring.definition.c_removedefinition;

import com.xschen.spring.definition.c_removedefinition.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xschen
 */


public class RemoveBeanDefinitionApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "definition/remove-definition.xml");

        Person james = (Person) ctx.getBean("james");
        System.out.println(james);

    }
}
