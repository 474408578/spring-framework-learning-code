package com.xschen.architecture.c_reflect.service.impl;

import com.xschen.architecture.c_reflect.dao.DemoDao;
import com.xschen.architecture.c_reflect.dao.impl.DemoDaoImpl;
import com.xschen.architecture.c_reflect.service.DemoService;

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
