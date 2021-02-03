package com.xschen.architecture.m_proxyfactory.service.impl;

import com.xschen.architecture.m_proxyfactory.dao.DemoDao;
import com.xschen.architecture.m_proxyfactory.factory.BeanFactory;
import com.xschen.architecture.m_proxyfactory.service.DemoService;

import java.util.List;

/**
 * @author xschen
 */
public class DemoServiceImpl implements DemoService {
    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");

    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }

    @Override
    public int add(String userId, int points) {
        return 0;
    }

    @Override
    public int subtract(String userId, int points) {
        return 0;
    }

    @Override
    public int multiply(String userId, int points) {
        return 0;
    }

    @Override
    public int divide(String userId, int points) {
        return 0;
    }
}
