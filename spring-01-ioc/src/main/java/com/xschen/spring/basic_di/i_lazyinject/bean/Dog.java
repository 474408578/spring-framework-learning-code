package com.xschen.spring.basic_di.i_lazyinject.bean;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
public class Dog {
    @Autowired
    private ObjectProvider<Person> personProvider;

    @Override
    public String toString() {
        return "Dog{" +
                "personProvider=" + personProvider.getIfAvailable(Person::new) +
                '}';
    }
}
