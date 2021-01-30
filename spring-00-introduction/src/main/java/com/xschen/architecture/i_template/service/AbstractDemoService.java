package com.xschen.architecture.i_template.service;

import com.xschen.architecture.i_template.utils.LogUtils;

/**
 * 模板模式
 * @author xschen
 */


public abstract class AbstractDemoService implements DemoService {

    @Override
    public int add(String userId, int points) {
        // 父类额外执行的逻辑
        LogUtils.printLog("DemoService", "add", userId, points);
        return doAdd(userId, points);
    }

    @Override
    public int subtract(String userId, int points) {
        LogUtils.printLog("DemoService", "subtract", userId, points);
        return doSubtract(userId, points);
    }

    @Override
    public int multiply(String userId, int points) {
        LogUtils.printLog("DemoService", "multiply", userId, points);
        return doMultiply(userId, points);
    }

    @Override
    public int divide(String userId, int points) {
        LogUtils.printLog("DemoService", "divide", userId, points);
        return doDivide(userId, points);
    }

    // 子类负责业务功能的实现
    protected abstract int doAdd(String userId, int points);

    protected abstract int doSubtract(String userId, int points);

    protected abstract int doMultiply(String userId, int points);

    protected abstract int doDivide(String userId, int points);
}
