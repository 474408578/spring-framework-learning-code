package com.xschen.architecture.k_dynamicproxy.service.impl;

import com.xschen.architecture.k_dynamicproxy.dao.DemoDao;
import com.xschen.architecture.k_dynamicproxy.factory.BeanFactory;
import com.xschen.architecture.k_dynamicproxy.service.DemoService;
import com.xschen.architecture.k_dynamicproxy.utils.LogUtils;

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

    // 用户积分变动信息
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
