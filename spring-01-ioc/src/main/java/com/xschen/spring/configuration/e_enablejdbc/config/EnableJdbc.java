package com.xschen.spring.configuration.e_enablejdbc.config;

import com.xschen.spring.configuration.e_enablejdbc.components.JdbcConfigSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author xschen
 * spring的spi机制加载配置类，首先将配置类声明到META-INF/spring.factories
 *
 * SpringFramework中的SPI相比较于jdk原生的，更加高级，因为它不仅仅局限于接口/抽象类，它可以
 * 是任何一个类、接口、注解。也正是因为可以支持注解的SPI，这个特性在springboot中被疯狂利用（大名鼎鼎的@EnableAutoConfiguration）
 */

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(JdbcConfigSelector.class)
public @interface EnableJdbc {
}
