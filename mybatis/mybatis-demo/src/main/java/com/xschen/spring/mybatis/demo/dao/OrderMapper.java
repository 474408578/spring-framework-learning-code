package com.xschen.spring.mybatis.demo.dao;

import com.xschen.spring.mybatis.demo.domain.Order;

import java.util.List;

/**
 * @author xschen
 */
public interface OrderMapper {

    Order find(Long id);

    List<Order> findByCustomerId(Long customerId, Long startTime, Long endTime);

    Long save(Order order);
}
