package com.think.in.spring.bean.definition;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean别名示例
 * @author xschen
 */


public class BeanAliasDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        User user = (User) beanFactory.getBean("user");
        // 获取通过别名来获取User
        User xschenUser = (User) beanFactory.getBean("xschen-user");
        System.out.println("user == xschen-user: " + (user == xschenUser));
    }
}
