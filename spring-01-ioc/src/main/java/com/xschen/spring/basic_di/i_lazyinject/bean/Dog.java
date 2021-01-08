package com.xschen.spring.basic_di.i_lazyinject.bean;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 延时三种延迟注入
 * <p>属性字段的延迟注入</p>
 * <p>setter延迟注入</p>
 * <p>构造器的延迟注入</p>
 * @author xschen
 */

@Component
public class Dog {
    /**
     * 属性字段的延迟注入
     */
    @Autowired
    private ObjectProvider<Person> personProvider;
    @Override
    public String toString() {
        return "Dog{" +
                "personProvider=" + personProvider.getIfAvailable(Person::new) +
                '}';
    }


    /**
     * setter延迟注入
     */
//    private Person person;
//    @Autowired
//    public void setPersonProvider(ObjectProvider<Person> person) {
//        // 有bean才取出
//        this.person = person.getIfAvailable();
//    }

    /**
     * 构造器的延迟注入
     */
//    private Person person;
//    @Autowired
//    public Dog(ObjectProvider<Person> person) {
//        // 如果没有bean，则采用缺省策略创建
//        this.person = person.getIfAvailable(Person::new);
//    }
//
//    @Override
//    public String toString() {
//        return "Dog{" +
//                "person=" + person +
//                '}';
//    }
}
