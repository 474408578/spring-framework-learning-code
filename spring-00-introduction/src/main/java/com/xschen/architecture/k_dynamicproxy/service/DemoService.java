package com.xschen.architecture.k_dynamicproxy.service;

import java.util.List;

/**
 * @author xschen
 */


public interface DemoService {

    List<String> findAll();

    // 增加积分变动逻辑
    int add(String userId, int points);
    int subtract(String userId, int points);
    int multiply(String userId, int points);
    int divide(String userId, int points);
}
