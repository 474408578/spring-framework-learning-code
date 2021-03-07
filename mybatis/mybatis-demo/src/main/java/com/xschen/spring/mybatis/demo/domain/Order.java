package com.xschen.spring.mybatis.demo.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 电商平台中的订单
 * @author xschen
 */
public class Order {

    /**
     * CREATE TABLE `t_order` (
     *   `id` bigint NOT NULL AUTO_INCREMENT,
     *   `address_id` bigint DEFAULT NULL,
     *   `customer_id` bigint DEFAULT NULL,
     *   `create_time` bigint DEFAULT NULL,
     *   PRIMARY KEY (`id`)
     * )
     */
    private Long id;
    private Customer customer;
    private Address deliverAddress;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Long createTime;
    private BigDecimal totalPrice;
}
