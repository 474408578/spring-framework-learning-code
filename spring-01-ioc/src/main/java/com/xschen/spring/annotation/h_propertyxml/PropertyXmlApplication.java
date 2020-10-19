package com.xschen.spring.annotation.h_propertyxml;

import com.xschen.spring.annotation.h_propertyxml.bean.JdbcPropertyXml;
import com.xschen.spring.annotation.h_propertyxml.config.JdbcXmlPropertyConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class PropertyXmlApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                JdbcXmlPropertyConfiguration.class);

        System.out.println(ctx.getBean(JdbcPropertyXml.class).toString());
    }
}
