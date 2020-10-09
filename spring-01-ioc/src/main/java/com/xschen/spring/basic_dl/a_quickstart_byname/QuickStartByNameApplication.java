package com.xschen.spring.basic_dl.a_quickstart_byname;

import com.xschen.spring.basic_dl.a_quickstart_byname.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xschen
 *
 * dependency lookup
 */


public class QuickStartByNameApplication {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("basic_dl/quickstart-byname.xml");
        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
    }
}
