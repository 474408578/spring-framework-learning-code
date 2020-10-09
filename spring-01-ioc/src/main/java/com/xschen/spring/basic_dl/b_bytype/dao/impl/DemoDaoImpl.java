package com.xschen.spring.basic_dl.b_bytype.dao.impl;

import com.xschen.spring.basic_dl.b_bytype.dao.DemoDao;

import java.util.Arrays;
import java.util.List;

/**
 * @author xschen
 */


public class DemoDaoImpl implements DemoDao {
    public List<String> findAll() {
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}
