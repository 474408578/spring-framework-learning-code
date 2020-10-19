package com.xschen.spring.annotation.i_propertyyml;

import com.xschen.spring.annotation.i_propertyyml.config.JdbcYmlConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 */


public class PropertySourceYmlApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcYmlConfiguration.class);
        
    }
}
