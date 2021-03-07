package com.xschen.spring.mybatis.demo.dao;

import com.xschen.spring.mybatis.demo.domain.Customer;

/**
 * @author xschen
 */

public interface CustomerMapper {

    // 根据用户Id查询Customer(不查询Address)
    Customer find(Long id);

    // 根据用户Id查询Customer(同时查询Address)
    Customer findWithAddress(Long id);

    // 根据orderId查询Customer
    Customer findByOrderId(Long id);

    // 持久化Customer
    int save(Customer customer);
}
