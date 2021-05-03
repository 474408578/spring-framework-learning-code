package com.xschen.spring.transaction.f_listener.service;

import com.xschen.spring.transaction.f_listener.bean.User;
import com.xschen.spring.transaction.f_listener.dao.UserDao;
import com.xschen.spring.transaction.f_listener.event.UserSaveEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xschen
 */

@Service
public class UserService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private UserDao userDao;

    @Transactional
    public void saveUser() {
        User user = new User();
        user.setName("song");
        user.setTel("123");
        userDao.saveUser(user);
        System.out.println("User save ...");
        //applicationEventPublisher.publishEvent(user); // 使用 Payload 发布事件
        // 自定义事件
        applicationEventPublisher.publishEvent(new UserSaveEvent(user));
        //int i = 1 / 0;

    }
}
