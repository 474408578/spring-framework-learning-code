package com.xschen.architecture.a_original.service.impl;

import com.xschen.architecture.a_original.dao.DemoDao;
import com.xschen.architecture.a_original.dao.impl.DemoDaoImpl;
import com.xschen.architecture.a_original.service.DemoService;

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
