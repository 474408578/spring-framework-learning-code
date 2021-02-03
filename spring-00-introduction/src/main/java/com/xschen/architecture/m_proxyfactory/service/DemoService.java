package com.xschen.architecture.m_proxyfactory.service;

import java.util.List;

/**
 * @author xschen
 */
public interface DemoService {
    List<String> findAll();
    int add(String userId, int points);
    int subtract(String userId, int points);
    int multiply(String userId, int points);
    int divide(String userId, int points);
}
