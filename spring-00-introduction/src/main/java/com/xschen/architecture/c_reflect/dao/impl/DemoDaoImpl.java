package com.xschen.architecture.c_reflect.dao.impl;


import com.xschen.architecture.c_reflect.dao.DemoDao;

import java.util.Arrays;
import java.util.List;

/**
 * @author xschen
 */


public class DemoDaoImpl implements DemoDao {
    @Override
    public List<String> findAll() {
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}
