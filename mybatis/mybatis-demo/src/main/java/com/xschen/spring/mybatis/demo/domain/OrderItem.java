package com.xschen.spring.mybatis.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 抽象了订单中的购物条目
 * @author xschen
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    /**
     * CREATE TABLE `t_order_item` (
     *   `id` bigint NOT NULL AUTO_INCREMENT,
     *   `amount` int DEFAULT NULL,
     *   `order_id` bigint DEFAULT NULL,
     *   `product_id` bigint DEFAULT NULL,
     *   PRIMARY KEY (`id`)
     * )
     */
    private Long id;
    private int amount;
    private Long orderId;
    private Product product;
    private BigDecimal price;
}
