package com.xschen.springjpa;

import com.xschen.springjpa.dto.UserInfoID;
import com.xschen.springjpa.dto.UserInfoID2;
import com.xschen.springjpa.entity.UserInfo;
import com.xschen.springjpa.entity.UserInfo2;
import com.xschen.springjpa.repository.UserInfoRepository;
import com.xschen.springjpa.repository.UserInfoRepository2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @author xschen
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class EntityDemoTests {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserInfoRepository2 userInfoRepository2;

    @Test
    public void testIdClass() {
        UserInfo jack = UserInfo.builder().name("jack").telephone("123456").age(18).build();
        userInfoRepository.save(jack);
        UserInfoID jackUnionKey = UserInfoID.builder().name("jack").telephone("123456").build();
        Optional<UserInfo> userInfo = userInfoRepository.findById(jackUnionKey);
        System.out.println(userInfo.get());
    }

    @Test
    public void testEmbeddedId() {
        UserInfo2 jack = UserInfo2.builder().userInfoID2(UserInfoID2.builder().name("jack").telephone("123456").build())
                .age(18).build();
        userInfoRepository2.save(jack);

        UserInfoID2 jackUnionKey = UserInfoID2.builder().name("jack").telephone("123456").build();
        Optional<UserInfo2> userInfo = userInfoRepository2.findById(jackUnionKey);
        System.out.println(userInfo.get());
    }
}
