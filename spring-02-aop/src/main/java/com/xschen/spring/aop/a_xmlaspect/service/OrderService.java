package com.xschen.spring.aop.a_xmlaspect.service;

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
