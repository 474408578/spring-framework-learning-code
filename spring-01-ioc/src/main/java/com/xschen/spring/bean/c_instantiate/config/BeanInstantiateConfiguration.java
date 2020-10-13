package com.xschen.spring.bean.c_instantiate.config;

import com.xschen.spring.bean.c_instantiate.bean.BallBeanFactory;
import com.xschen.spring.bean.c_instantiate.bean.Car;
import com.xschen.spring.bean.c_instantiate.bean.CarStaticFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
@ComponentScan("com.xschen.spring.bean.c_instantiate.bean")
public class BeanInstantiateConfiguration {

    @Bean
    public BallBeanFactory ballBeanFactory() {
        return new BallBeanFactory();
    }

    // 编程式使用静态工厂
    @Bean
    public Car car2() {
        return CarStaticFactory.getCar();
    }
}
