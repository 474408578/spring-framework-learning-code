package com.xschen.architecture.h_decorator.service.impl;

import com.xschen.architecture.h_decorator.dao.DemoDao;
import com.xschen.architecture.h_decorator.factory.BeanFactory;
import com.xschen.architecture.h_decorator.service.DemoService;
import com.xschen.architecture.h_decorator.utils.LogUtils;

import java.util.List;

/**
 * @author xschen
 */


public class DemoServiceImpl2 implements DemoService {
    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");

    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }

    @Override
    public int add(String userId, int points) {
        return points;
    }

    @Override
    public int subtract(String userId, int points) {
        return points;
    }

    @Override
    public int multiply(String userId, int points) {
        return points;
    }

    @Override
    public int divide(String userId, int points) {
        return points;
    }
}
