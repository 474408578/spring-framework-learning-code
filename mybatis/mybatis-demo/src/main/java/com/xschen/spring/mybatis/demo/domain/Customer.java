package com.xschen.spring.mybatis.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 电商平台中的用户
 * @author xschen
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    /**
     * CREATE TABLE `t_customer` (
     *   `id` bigint NOT NULL AUTO_INCREMENT,
     *   `name` varchar(255) NOT NULL,
     *   `phone` varchar(255) DEFAULT NULL,
     *   PRIMARY KEY (`id`)
     * )
     */
    private Long id;
    private String name;
    private String phone;
    private List<Address> addresses = new ArrayList<>();
}
