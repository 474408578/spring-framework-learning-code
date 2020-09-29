package com.xschen.architecture.a_original.dao.impl;

import com.xschen.architecture.a_original.dao.DemoDao;

import java.util.Arrays;
import java.util.List;

/**
 * @author xschen
 */


public class DemoDaoImpl implements DemoDao {
    @Override
    public List<String> findAll() {
        // 此处应该是访问数据库，使用临时数据代替
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}
