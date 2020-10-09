package com.xschen.spring.basic_dl.b_bytype;

import com.xschen.spring.basic_dl.b_bytype.bean.Person;
import com.xschen.spring.basic_dl.b_bytype.dao.DemoDao;
import com.xschen.spring.basic_dl.b_bytype.dao.impl.DemoDaoImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xschen
 */


public class QuickstartByTypeApplication {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("basic_dl/quickstart-bytype.xml");
        Person person = factory.getBean(Person.class);
        System.out.println(person);

        DemoDao demoDao = factory.getBean(DemoDaoImpl.class);
        System.out.println(demoDao.findAll().toString());
    }
}
