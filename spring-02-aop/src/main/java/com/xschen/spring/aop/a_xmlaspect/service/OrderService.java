package com.xschen.spring.aop.a_xmlaspect.service;

import java.util.List;

/**
 * 订单 Service 接口
 * @author xschen
 */


public interface OrderService {

    void createOrder();

    void deleteOrderById(String id);

    String getOrderById(String id);

    List<String> findAll();
}
