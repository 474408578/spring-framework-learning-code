package com.xschen.spring.annotation.g_propertysource;

import com.xschen.spring.annotation.g_propertysource.bean.JdbcProperties;
import com.xschen.spring.annotation.g_propertysource.config.JdbcPropertiesConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author xschen
 */


public class PropertySourcePropertiesApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                JdbcPropertiesConfiguration.class);
        System.out.println(ctx.getBean(JdbcProperties.class).toString());
    }
}
