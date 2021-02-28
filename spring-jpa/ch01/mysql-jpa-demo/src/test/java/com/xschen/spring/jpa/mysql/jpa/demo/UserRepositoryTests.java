package com.xschen.spring.jpa.mysql.jpa.demo;

import com.xschen.spring.jpa.mysql.jpa.demo.entity.User;
import com.xschen.spring.jpa.mysql.jpa.demo.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

/**
 * @author xschen
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = userRepository.save(User.builder().name("xschen").email("1638392300@qq.com").build());
        Assert.assertNotNull(user);
        List<User> userList = userRepository.findAll();
        userList.forEach(System.out::println);
    }

}
