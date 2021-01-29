package com.xschen.architecture.f_pointslog.service.impl;

import com.xschen.architecture.f_pointslog.dao.DemoDao;
import com.xschen.architecture.f_pointslog.factory.BeanFactory;
import com.xschen.architecture.f_pointslog.service.DemoService;

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
        System.out.println("DemoServiceImpl add ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }

    @Override
    public int subtract(String userId, int points) {
        // 增加记录日志
        System.out.println("DemoServiceImpl subtract ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }

    @Override
    public int multiply(String userId, int points) {
        // 增加记录日志
        System.out.println("DemoServiceImpl multiply ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }

    @Override
    public int divide(String userId, int points) {
        // 增加记录日志
        System.out.println("DemoServiceImpl divide ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }
}
