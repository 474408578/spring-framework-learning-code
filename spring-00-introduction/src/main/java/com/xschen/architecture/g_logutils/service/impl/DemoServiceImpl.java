package com.xschen.architecture.g_logutils.service.impl;

import com.xschen.architecture.g_logutils.dao.DemoDao;
import com.xschen.architecture.g_logutils.factory.BeanFactory;
import com.xschen.architecture.g_logutils.service.DemoService;
import com.xschen.architecture.g_logutils.utils.LogUtils;

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
        // 增加记录日志
        LogUtils.printLog("DemoServiceImpl", "add", userId, points);
        return points;
    }

    @Override
    public int subtract(String userId, int points) {
        // 增加记录日志
        LogUtils.printLog("DemoServiceImpl", "subtract", userId, points);
        return points;
    }

    @Override
    public int multiply(String userId, int points) {
        // 增加记录日志
        LogUtils.printLog("DemoServiceImpl", "multiply", userId, points);
        return points;
    }

    @Override
    public int divide(String userId, int points) {
        // 增加记录日志
        LogUtils.printLog("DemoServiceImpl", "divide", userId, points);
        return points;
    }
}
