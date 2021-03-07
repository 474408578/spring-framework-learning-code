package com.xschen.spring.mybatis.demo.dao;

import com.xschen.spring.mybatis.demo.domain.Product;

/**
 * @author xschen
 */


public interface ProductMapper {
    Product find(Long id);
    Product findByName(String name);
    int save(Product product);
}
