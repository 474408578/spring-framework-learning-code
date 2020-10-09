package com.xschen.architecture.e_cachedfactory.service.impl;

import com.xschen.architecture.e_cachedfactory.dao.DemoDao;
import com.xschen.architecture.e_cachedfactory.factory.BeanFactory;
import com.xschen.architecture.e_cachedfactory.service.DemoService;

import java.util.List;

/**
 * @author xschen
 */


public class DemoServiceImpl implements DemoService {
    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");

    // 打印出一样的bean
    public DemoServiceImpl() {
        for (int i = 0; i < 10; i++) {
            System.out.println(BeanFactory.getBean("demoDao"));
        }
    }

    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
