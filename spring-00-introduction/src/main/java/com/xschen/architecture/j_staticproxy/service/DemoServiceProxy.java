package com.xschen.architecture.j_staticproxy.service;


import com.xschen.architecture.j_staticproxy.service.impl.DemoServiceImpl;
import com.xschen.architecture.j_staticproxy.utils.LogUtils;

import java.util.List;

/**
 * 静态代理，需要自行编写代理类，组合原有的目标对象，并实现原有目标对象实现的接口，
 * 以此来做到对原有对象的方法功能的增强。
 * @author xschen
 */


public class DemoServiceProxy implements DemoService {
    private DemoServiceImpl demoService;

    public DemoServiceProxy(DemoServiceImpl demoService) {
        this.demoService = demoService;
    }

    @Override
    public List<String> findAll() {
        return demoService.findAll();
    }

    @Override
    public int add(String userId, int points) {
        LogUtils.printLog("DemoService", "add", userId, points);
        return demoService.add(userId, points);
    }

    @Override
    public int subtract(String userId, int points) {
        LogUtils.printLog("DemoService", "subtract", userId, points);
        return demoService.subtract(userId, points);
    }

    @Override
    public int multiply(String userId, int points) {
        LogUtils.printLog("DemoService", "multiply", userId, points);
        return demoService.multiply(userId, points);
    }

    @Override
    public int divide(String userId, int points) {
        LogUtils.printLog("DemoService", "divide", userId, points);
        return demoService.divide(userId, points);
    }
}
