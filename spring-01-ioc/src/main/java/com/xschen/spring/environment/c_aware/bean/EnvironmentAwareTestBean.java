package com.xschen.spring.environment.c_aware.bean;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @author xschen
 * 回调注入Environment
 */


public class EnvironmentAwareTestBean implements EnvironmentAware {
    private Environment environment;
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void printEnvironment() {
        System.out.println(environment);
    }
}