package com.xschen.spring.mybatis.demo.dao;

import com.xschen.spring.mybatis.demo.domain.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xschen
 */


public interface AddressMapper {

    Address find(Long id);

    List<Address> findAll(Long customerId);

    Address findByOrderId(Long orderId);

    int save(@Param("address") Address address, @Param("customerId") Long customerId);
}
