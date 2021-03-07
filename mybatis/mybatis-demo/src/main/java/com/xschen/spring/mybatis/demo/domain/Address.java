package com.xschen.spring.mybatis.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户的送货地址
 * @author xschen
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    /**
     * CREATE TABLE `t_address` (
     *   `id` bigint NOT NULL AUTO_INCREMENT,
     *   `street` varchar(255) DEFAULT NULL,
     *   `city` varchar(255) DEFAULT NULL,
     *   `country` varchar(255) DEFAULT NULL,
     *   `customer_id` bigint DEFAULT NULL,
     *   PRIMARY KEY (`id`)
     * )
     */
    private Long id;
    private String street;
    private String city;
    private String country;
}
