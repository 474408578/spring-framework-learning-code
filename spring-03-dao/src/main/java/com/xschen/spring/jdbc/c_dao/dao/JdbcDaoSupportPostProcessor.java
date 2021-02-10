package com.xschen.spring.jdbc.c_dao.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;

/**
 * 借助后置处理器来让继承了JdbcDao的类实例化出的对象都能够注入DataSource到setDataSource中
 * @author xschen
 */


public class JdbcDaoSupportPostProcessor implements BeanPostProcessor {
    @Autowired
    private DataSource dataSource;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof JdbcDaoSupport) {
            JdbcDaoSupport daoSupport = (JdbcDaoSupport) bean;
            daoSupport.setDataSource(dataSource);
        }
        return bean;
    }
}
