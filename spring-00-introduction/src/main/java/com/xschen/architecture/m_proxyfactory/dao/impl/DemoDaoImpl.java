package com.xschen.architecture.m_proxyfactory.dao.impl;

import com.xschen.architecture.m_proxyfactory.dao.DemoDao;

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
