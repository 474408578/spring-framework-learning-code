package com.xschen.architecture.l_filtermethod.service.impl;

import com.xschen.architecture.l_filtermethod.dao.DemoDao;
import com.xschen.architecture.l_filtermethod.factory.BeanFactory;
import com.xschen.architecture.l_filtermethod.service.DemoService;
import com.xschen.architecture.l_filtermethod.utils.LogUtils;

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
        LogUtils.printLog("DemoServiceImpl2", "add", userId, points);
        return points;
    }

    @Override
    public int subtract(String userId, int points) {
        LogUtils.printLog("DemoServiceImpl2", "subtract", userId, points);
        return points;
    }

    @Override
    public int multiply(String userId, int points) {
        LogUtils.printLog("DemoServiceImpl2", "multiply", userId, points);
        return points;
    }

    @Override
    public int divide(String userId, int points) {
        LogUtils.printLog("DemoServiceImpl2", "divide", userId, points);
        return points;
    }
}
