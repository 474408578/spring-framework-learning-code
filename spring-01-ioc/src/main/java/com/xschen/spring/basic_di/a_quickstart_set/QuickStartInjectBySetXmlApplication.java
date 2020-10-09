package com.xschen.spring.basic_di.a_quickstart_set;

import com.xschen.spring.basic_di.a_quickstart_set.bean.Cat;
import com.xschen.spring.basic_di.a_quickstart_set.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xschen
 * todo: 基于xml的依赖注入
 *
 * dependency inject & dependency inject对比
 * 1、作用的目标对象不同
 *    依赖注入作用目标通常是类成员
 *    依赖查找作用目标通常是方法体内，也可以是方法体外
 *
 * 2、实现方式不同
 *    依赖注入通常借助一个上下文被动的接收
 *    依赖查找通常主动上下文搜索
 */


public class QuickStartInjectBySetXmlApplication {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("basic_di/inject-set.xml");
        Person person = factory.getBean(Person.class);
        System.out.println(person);

        Cat cat = factory.getBean(Cat.class);
        System.out.println(cat);
    }
}
