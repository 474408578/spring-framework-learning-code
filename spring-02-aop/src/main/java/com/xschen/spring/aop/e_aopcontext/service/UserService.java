package com.xschen.spring.aop.e_aopcontext.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 需求：每次调用UserService的方法都需要打印切面日志（自身调用自身的方法）
 *
 * @author xschen
 */

@Service
public class UserService {

    @Autowired
    UserService userService;

    public void update(String id, String name) {
//        this.get(id); // 不生效，只会打印一次
        /**
         * 不优雅的解决方案：
         *  利用依赖注入特性，使用 userService 调用自身方法.
         */
//        userService.get(id);
        ((UserService) AopContext.currentProxy()).get(id);
        System.out.println("修改指定id的name ......");
    }

    public void get(String id) {
        System.out.println("获取指定id的user ......");
    }
}
