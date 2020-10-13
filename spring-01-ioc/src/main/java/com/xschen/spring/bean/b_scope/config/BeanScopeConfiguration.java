package com.xschen.spring.bean.b_scope.config;

import com.xschen.spring.bean.b_scope.bean.Child;
import com.xschen.spring.bean.b_scope.bean.Toy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
@ComponentScan("com.xschen.spring.bean.b_scope.bean")
public class BeanScopeConfiguration {

    @Bean
    public Child child1(Toy toy) {
        Child child1 = new Child();
        child1.setToy(toy);
        return child1;
    }

    @Bean
    public Child child2(Toy toy) {
        Child child2 = new Child();
        child2.setToy(toy);
        return child2;
    }

}
