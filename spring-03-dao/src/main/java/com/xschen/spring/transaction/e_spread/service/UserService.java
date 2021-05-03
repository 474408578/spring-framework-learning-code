package com.xschen.spring.transaction.e_spread.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author xschen
 */

@Service
public class UserService {

    @Autowired
    private PointService pointService;

    /**
     * 用户注册与充值积分是一个原子性的操作
     */
    @Transactional
    public void register() {
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
        // 持久化操作 ......
        System.out.println("register 注册用户 ......");
        /**
         * addPoint() 中有事务，在register()中被调用时，register()中也开启了事务，那addPoint()的事务和 register()中的事务该怎么配合？？
         *   1. addPoint()的事务加入到当前事务中 ---- REQUIRED
         *   2. 重新给pointService.addPoint()开一个事务 ---- REQUIRES_NEW
         *   3. 利用保存点的方案 ---- NESTED
         */
        pointService.addPoint();
    }
}
