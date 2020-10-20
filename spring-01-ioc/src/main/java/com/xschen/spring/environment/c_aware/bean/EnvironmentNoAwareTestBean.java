package com.xschen.spring.environment.c_aware.bean;

import org.springframework.core.env.Environment;

/**
 * @author xschen
 */


public class EnvironmentNoAwareTestBean {
    private Environment environment;
    public void printEnvironment() {
        System.out.println(environment);
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
