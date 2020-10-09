package com.xschen.spring.annotation.a_quickstart.config;

import com.xschen.spring.annotation.a_quickstart.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
public class QuickStartConfiguration {

    /**
     * 向IOC容器注册一个类型为Person，id为person的bean
     * 方法的返回值代表注册的类型，方法名代表bean的id
     *
     * 当然，也可以直接在 @Bean 注解上显式的声明 Bean 的 id ，
     * 只不过在注解驱动的范畴里，它不叫 id 而是叫 name ：
     * @return
     */
//    @Bean(name = "person") // 4.3.3之后可以直接写value
    @Bean
    public Person person() {
        return new Person();
    }
}
