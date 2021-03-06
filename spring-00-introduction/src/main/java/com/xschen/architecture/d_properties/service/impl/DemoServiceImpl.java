package com.xschen.architecture.d_properties.service.impl;

import com.xschen.architecture.d_properties.dao.DemoDao;
import com.xschen.architecture.d_properties.factory.BeanFactory;
import com.xschen.architecture.d_properties.service.DemoService;

import java.util.List;

/**
 * @author xschen
 */


public class DemoServiceImpl implements DemoService {
    DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");

    // 会实例化多个不同的bean
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
