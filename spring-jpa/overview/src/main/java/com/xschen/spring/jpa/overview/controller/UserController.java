package com.xschen.spring.jpa.overview.controller;

import com.xschen.spring.jpa.overview.domain.User;
import com.xschen.spring.jpa.overview.domain.UserDto;
import com.xschen.spring.jpa.overview.domain.UserExtend;
import com.xschen.spring.jpa.overview.domain.UserSimpleDto;
import com.xschen.spring.jpa.overview.repository.PagingAndSortingUserRepository;
import com.xschen.spring.jpa.overview.repository.UserDtoRepository;
import com.xschen.spring.jpa.overview.repository.UserExtendRepository;
import com.xschen.spring.jpa.overview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author xschen
 */

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PagingAndSortingUserRepository pagingAndSortingUserRepository;
    @Autowired
    private UserDtoRepository userDtoRepository;
    @Autowired
    private UserExtendRepository userExtendRepository;

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping(path = "user",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addNewUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    /**
     * 获取所有用户
     * @param req
     * @return
     */
    @GetMapping(path = "users")
    public List<User> getAllUsers(Pageable req) {
        return userRepository.findAll();
    }

    @GetMapping(path = "user1")
    public List<User> getUserByName(@RequestParam("name") String name) {
        return userRepository.findByName(name);
    }

    @PostMapping(path = "user2",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@RequestBody User user) {
        User user1 = userRepository.findByUser(user);
        return user1;
    }

    @GetMapping(path = "singleUser1")
    public List<User> getUserByNameAndEmail1(@RequestParam("name") String name, @RequestParam("email") String email) {
        return userRepository.findByNameAndEmail(name, email);
    }

    @GetMapping(path = "singleUser2")
    public User getUserByNameAndEmail2(@RequestParam("name") String name, @RequestParam("email") String email) {
        return userRepository.findByNameAndEmail2(name, email);
    }

    /**
     * 根据排序和分页查询，Pageable的默认实现类：PageRequest
     */
    @GetMapping(path = "page")
    public Page<User> getAllUserByPage() {
        return pagingAndSortingUserRepository
                .findAll(PageRequest.of(0,20,
                        Sort.by(new Sort.Order(Sort.Direction.ASC, "name"))));
    }

    /**
     * 排序查询方法，使用sort对象
     * @return
     */
    public Iterable<User> getAllUserWithSort() {
        return pagingAndSortingUserRepository
                .findAll(Sort.by(new Sort.Order(Sort.Direction.ASC, "name")));
    }

    @GetMapping("userDto1")
    public UserDto getUserById1(@RequestParam("id") Long id) {
        List<Object[]> objects = userDtoRepository.findByUserDtoId1(id);
        UserDto userDto = new UserDto();
        userDto.setName((String) objects.get(0)[0]);
        userDto.setEmail((String) objects.get(0)[1]);
        userDto.setIdCard((String) objects.get(0)[2]);
        return userDto;
    }

    @GetMapping("userDto2")
    public UserDto getUserById2(@RequestParam("id") Long id) {
        UserDto userDto = userDtoRepository.findByUserDtoId2(id);
        return userDto;
    }

    @GetMapping("userDto3")
    public UserSimpleDto getUserById3(@RequestParam("id") Long id) {
        UserSimpleDto userSimpleDto = userDtoRepository.findByUserDtoId3(id);
        return userSimpleDto;
    }

    @PostConstruct
    private void initData() {
        User xschen = User.builder().name("xschen").email("1638392300@qq.com").build();
        userRepository.save(xschen);
        User xiangsong = User.builder().name("xiangsong").email("474408578@qq.com").build();
        userRepository.save(xiangsong);
        UserExtend userExtend = UserExtend.builder().userId(1L).age(23).idCard("123456").build();
        userExtendRepository.save(userExtend);
    }
}
