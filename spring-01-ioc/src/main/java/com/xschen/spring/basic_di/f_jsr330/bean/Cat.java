package com.xschen.spring.basic_di.f_jsr330.bean;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author xschen
 */

@Component
public class Cat {
    private String name = "mimi";

    @Inject // 等同于@Autowired
    @Named("admin") // 等同于@Qualifier
    private Person master;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", master=" + master +
                '}';
    }
}
