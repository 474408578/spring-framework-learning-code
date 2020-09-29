package com.xschen.architecture.b_factory.factory;

import com.xschen.architecture.b_factory.dao.DemoDao;
import com.xschen.architecture.b_factory.dao.impl.DemoDaoImpl;
import com.xschen.architecture.b_factory.dao.impl.DemoMysqlDao;
import com.xschen.architecture.b_factory.service.DemoService;
import com.xschen.architecture.b_factory.service.impl.DemoServiceImpl;
import com.xschen.architecture.b_factory.service.impl.DemoServiceImpl2;

/**
 * @author xschen
 */


public class BeanFactory {
    public static DemoService getDemoService() {

//        return new DemoServiceImpl();
        return new DemoServiceImpl2();
    }

    public static DemoDao getDemoDao() {
        return new DemoDaoImpl();
//        return new DemoMysqlDao();
    }
}
