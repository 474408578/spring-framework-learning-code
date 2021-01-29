package com.xschen.architecture.i_template.service.impl;

import com.xschen.architecture.i_template.dao.DemoDao;
import com.xschen.architecture.i_template.factory.BeanFactory;
import com.xschen.architecture.i_template.service.AbstractDemoService;
import com.xschen.architecture.i_template.service.DemoService;
import com.xschen.architecture.i_template.utils.LogUtils;

import java.util.List;

/**
 * @author xschen
 */


public class DemoServiceImpl2 extends AbstractDemoService implements DemoService {
    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");

    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }

    @Override
    protected int doAdd(String userId, int points) {
        return points;
    }

    @Override
    protected int doSubtract(String userId, int points) {
        return points;
    }

    @Override
    protected int doMultiply(String userId, int points) {
        return points;
    }

    @Override
    protected int doDivide(String userId, int points) {
        return points;
    }
}
