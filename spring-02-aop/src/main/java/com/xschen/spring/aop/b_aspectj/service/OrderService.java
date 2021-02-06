package com.xschen.spring.aop.b_aspectj.service;

import java.util.List;

/**
 * @author xschen
 */


public interface OrderService {

    void createOrder();

    void deleteOrderById(String id);

    String getOrderById(String id);

    List<String> findAll();
}
