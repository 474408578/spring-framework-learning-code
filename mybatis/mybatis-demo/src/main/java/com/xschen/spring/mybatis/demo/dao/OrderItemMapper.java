package com.xschen.spring.mybatis.demo.dao;

import com.xschen.spring.mybatis.demo.domain.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xschen
 */

public interface OrderItemMapper {

    OrderItem find(Long id);

    List<OrderItem> findByOrderId(Long orderId);

    int save(@Param("orderItem") OrderItem orderItem, @Param("orderId") Long orderId);
}
