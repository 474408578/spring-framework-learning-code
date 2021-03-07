package com.xschen.spring.mybatis.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 商品
 * @author xschen
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    /**
     * CREATE TABLE `t_product` (
     *   `id` bigint NOT NULL AUTO_INCREMENT,
     *   `name` varchar(255) DEFAULT NULL,
     *   `description` varchar(255) DEFAULT NULL,
     *   `price` bigint DEFAULT NULL,
     *   PRIMARY KEY (`id`)
     * )
     */
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
