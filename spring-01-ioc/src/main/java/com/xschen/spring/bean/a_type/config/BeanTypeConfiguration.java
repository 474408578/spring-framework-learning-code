package com.xschen.spring.bean.a_type.config;

import com.xschen.spring.bean.a_type.bean.Ball;
import com.xschen.spring.bean.a_type.bean.Child;
import com.xschen.spring.bean.a_type.bean.Toy;
import com.xschen.spring.bean.a_type.bean.ToyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 * todo：注册bean
 */

@Component
@ComponentScan("com.xschen.spring.bean.a_type.bean")
public class BeanTypeConfiguration {


    @Bean
    public Child child() {
        return new Child();
    }

//    @Bean
//    public Toy ball() {
//        return new Ball("ball");
//    }

    @Bean
    public ToyFactoryBean toyFactory() {
        ToyFactoryBean toyFactory = new ToyFactoryBean();
        toyFactory.setChild(child());
        return toyFactory;
    }
}
