package com.xschen.spring.annotation.i_propertyyml.config;

import com.xschen.spring.annotation.i_propertyyml.factory.YmlPropertySourceFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xschen
 */

@Configuration
@ComponentScan("com.xschen.spring.annotation.i_propertyyml.bean")
@PropertySource(value = "classpath:annotation/propertyyml/jdbc.yml",
        factory = YmlPropertySourceFactory.class)
public class JdbcYmlConfiguration {
}
