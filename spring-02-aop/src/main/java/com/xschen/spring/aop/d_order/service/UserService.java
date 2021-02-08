package com.xschen.spring.aop.d_order.service;

import org.springframework.stereotype.Service;

/**
 * @author xschen
 */

@Service
public class UserService {

    public void saveUser(String id) {
        System.out.println("UserService save user: " + id);
    }
}
