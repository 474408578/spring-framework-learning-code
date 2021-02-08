package com.xschen.spring.aop.e_aopcontext.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 需求：每次调用UserService的方法都需要打印切面日志
 *
 * @author xschen
 */

@Service
public class UserService {

    @Autowired
    UserService userService;

    public void update(String id, String name) {
//        this.get(id);
//        userService.get(id); // 不优雅的解决方案
        ((UserService) AopContext.currentProxy()).get(id);
        System.out.println("修改制定id的name ......");
    }

    public void get(String id) {
        System.out.println("获取指定id的user ......");
    }
}
