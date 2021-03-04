package com.xschen.springjpa.query.demo;

import com.xschen.springjpa.query.demo.dto.UserDto;
import com.xschen.springjpa.query.demo.dto.UserOnlyNameAndEmailDto;
import com.xschen.springjpa.query.demo.dto.UserSimpleDto;
import com.xschen.springjpa.query.demo.entity.User;
import com.xschen.springjpa.query.demo.entity.UserExtend;
import com.xschen.springjpa.query.demo.repository.UserDtoRepository;
import com.xschen.springjpa.query.demo.repository.UserExtendRepository;
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
public class QueryDemoTests {

    @Autowired
    private UserDtoRepository userDtoRepository;
    @Autowired
    private UserExtendRepository userExtendRepository;

    /**
     * 手动编码组合数据获取UserDto
     */
    @Test
    public void testQueryAnnotation() {
//        userDtoRepository.save(User.builder().name("jack").email("123456@126.com").sex("male").address("shanghai").build());
//        userExtendRepository.save(UserExtend.builder().userId(1L).idCard("shengfengzhenghao").age(18).studentNumber("xuehao001").build());
        List<Object[]> userArray = userDtoRepository.findByUserId(1L);
        System.out.println(String.valueOf(userArray.get(0)[0]) + String.valueOf(userArray.get(0)[1]));
        UserDto userDto = UserDto.builder()
                .name(String.valueOf(userArray.get(0)[0]))
                .email(String.valueOf(userArray.get(0)[1]))
                .idCard(String.valueOf(userArray.get(0)[2]))
                .build();

        System.out.println(userDto);
    }

    /**
     * 通过new dto 获取UserDto
     */
    @Test
    public void testQueryAnnotationDto() {
        UserDto userDto = userDtoRepository.findByUserDtoId(1L);
        System.out.println(userDto);
    }

    /**
     * 通过 UserSimpleDto 接口
     */
    @Test
    public void testQueryAnnotationDtoInterface() {
        UserSimpleDto userSimpleDto = userDtoRepository.findByUserSimpleDtoId(1L);
        System.out.println(userSimpleDto);
        System.out.println(userSimpleDto.getName() + "-" +
                userSimpleDto.getEmail() + "-" + userSimpleDto.getIdCard());
    }

    /**
     * 利用JQPl动态查询用户信息
     */
    @Test
    public void testQueryAnnotationDtoInterface2() {
        UserOnlyNameAndEmailDto userDto = userDtoRepository.findByUser("xschen", null);
        System.out.println(userDto.getName() + "-" + userDto.getEmail());
    }

    @Test
    public void testNatureComplexQuery() {
        UserOnlyNameAndEmailDto userDto = userDtoRepository.findByUserNature(User.builder().name("xschen").build());
        System.out.println(userDto.getName() + "-" + userDto.getEmail());
    }
}