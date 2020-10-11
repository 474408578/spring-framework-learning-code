package com.xschen.spring.basic_di.d_autowired.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xschen
 */


@Component
public class Dog {
    @Value("dogdog")
    private String name;

    @Autowired
    @Qualifier(value = "administrator") //Autowired是按照类型注入的，使用Qualifier来指定bean 名称
    private Person person;

    // 将Person类型的Bean全部注入
    @Autowired
    private List<Person> persons;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", person=" + person +
                ", persons=" + persons +
                '}';
    }
}
