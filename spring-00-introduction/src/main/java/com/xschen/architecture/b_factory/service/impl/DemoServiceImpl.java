package com.xschen.architecture.b_factory.service.impl;

import com.xschen.architecture.b_factory.dao.DemoDao;
import com.xschen.architecture.b_factory.dao.impl.DemoDaoImpl;
import com.xschen.architecture.b_factory.service.DemoService;

import java.util.List;

/**
 * @author xschen
 */


public class DemoServiceImpl implements DemoService {
    DemoDao demoDao = new DemoDaoImpl();
    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
