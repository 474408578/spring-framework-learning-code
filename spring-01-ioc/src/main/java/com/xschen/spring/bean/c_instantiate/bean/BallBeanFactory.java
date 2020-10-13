package com.xschen.spring.bean.c_instantiate.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author xschen
 */


public class BallBeanFactory implements FactoryBean<Ball> {
    @Override
    public Ball getObject() throws Exception {
        return new Ball();
    }

    @Override
    public Class<?> getObjectType() {
        return Ball.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
