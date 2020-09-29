package com.xschen.architecture.b_factory.dao.impl;

import com.xschen.architecture.b_factory.dao.DemoDao;

import java.util.Arrays;
import java.util.List;

/**
 * @author xschen
 */


public class DemoMysqlDao implements DemoDao {
    @Override
    public List<String> findAll() {
        // jdbc operations ......
        System.out.println("DemoMySQLDao findAll run ......");
        return Arrays.asList("aaa", "bbb", "ccc", "DemoMySQLDao");
    }
}
