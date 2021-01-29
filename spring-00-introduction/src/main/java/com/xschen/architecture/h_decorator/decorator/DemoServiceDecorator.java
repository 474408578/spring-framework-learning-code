package com.xschen.architecture.h_decorator.decorator;


import com.xschen.architecture.h_decorator.service.DemoService;
import com.xschen.architecture.h_decorator.utils.LogUtils;

import java.util.List;

/**
 * @author xschen
 */


public class DemoServiceDecorator implements DemoService {

    private DemoService target;

    public DemoServiceDecorator(DemoService target) {
        this.target = target;
    }

    @Override
    public List<String> findAll() {
        return target.findAll();
    }

    @Override
    public int add(String userId, int points) {
        LogUtils.printLog("DemoService", "add", userId, points);
        return target.add(userId, points);
    }

    @Override
    public int subtract(String userId, int points) {
        LogUtils.printLog("DemoService", "subtract", userId, points);
        return target.subtract(userId, points);
    }

    @Override
    public int multiply(String userId, int points) {
        LogUtils.printLog("DemoService", "multiply", userId, points);
        return target.multiply(userId, points);
    }

    @Override
    public int divide(String userId, int points) {
        LogUtils.printLog("DemoService", "divide", userId, points);
        return target.divide(userId, points);
    }
}
