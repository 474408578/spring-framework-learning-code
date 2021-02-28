package com.xschen.spring.jpa.repository.demo;

import com.xschen.spring.jpa.repository.demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author xschen
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testJpa() {
        userRepository.deleteAll();
        userRepository.findAll();
        userRepository.findByEmailAddress("1638392300@qq.com");
    }
}
