package com.xschen.architecture.f_pointslog.service.impl;

import com.xschen.architecture.f_pointslog.dao.DemoDao;
import com.xschen.architecture.f_pointslog.factory.BeanFactory;
import com.xschen.architecture.f_pointslog.service.DemoService;

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
        System.out.println("DemoServiceImp2 add ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }

    @Override
    public int subtract(String userId, int points) {
        System.out.println("DemoServiceImp2 subtract ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }

    @Override
    public int multiply(String userId, int points) {
        System.out.println("DemoServiceImp2 multiply ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }

    @Override
    public int divide(String userId, int points) {
        System.out.println("DemoServiceImp2 divide ...");
        System.out.println("user: " + userId + ", points: " + points);
        return points;
    }
}
