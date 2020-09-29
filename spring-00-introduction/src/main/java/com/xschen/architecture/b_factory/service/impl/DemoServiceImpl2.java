package com.xschen.architecture.b_factory.service.impl;

import com.xschen.architecture.b_factory.dao.DemoDao;
import com.xschen.architecture.b_factory.factory.BeanFactory;
import com.xschen.architecture.b_factory.service.DemoService;

import java.util.List;

/**
 * @author xschen
 */


public class DemoServiceImpl2 implements DemoService {
    DemoDao demoDao = BeanFactory.getDemoDao();
    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
