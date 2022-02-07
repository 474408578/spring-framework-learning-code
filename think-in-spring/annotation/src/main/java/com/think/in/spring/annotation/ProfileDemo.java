package com.think.in.spring.annotation;

import org.springframework.context.annotation.*;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 *
 * {@link Profile} 示例
 * @author xschen
 * @date 2021/12/16 9:44
 *
 * @see ConfigurableEnvironment
 * @see AbstractEnvironment
 */
@ComponentScan(basePackages = "com.think.in.spring.annotation")
public class ProfileDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册Configuration class
        context.register(ProfileDemo.class);

        // 获取 Environment 对象（可配置的）
        ConfigurableEnvironment environment = context.getEnvironment();

        // 默认 profiles = [ "odd" ] （兜底 profiles)
        environment.setDefaultProfiles("odd");
        // 增加活跃 profiles
        // --spring.profiles.active = even
        // -Dspring.profiles.active=even
        environment.setActiveProfiles("even");

        context.refresh();

        Integer number = context.getBean("number", Integer.class);
        System.out.println(number);

        context.close();

    }

    @Bean(name = "number")
    @Profile("odd") // 奇数
    public Integer odd() {
        return 1;
    }

    @Bean(name = "number")
    //@Profile("even") // 偶数
    @Conditional(EvenProfileCondition.class)
    public Integer even() {
        return 2;
    }
}
