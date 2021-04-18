package com.xschen.spring.aop.g_weawer.service;

import org.springframework.stereotype.Service;

/**
 * @author xschen
 */


@Service
public class UserService {

    public void get(String id) {
        System.out.println("获取id为" + id + "的用户。。。");
    }
}