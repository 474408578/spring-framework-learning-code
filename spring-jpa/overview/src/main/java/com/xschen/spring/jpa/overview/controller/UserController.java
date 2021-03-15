package com.xschen.spring.jpa.overview.controller;

import com.xschen.spring.jpa.overview.domain.User;
import com.xschen.spring.jpa.overview.repository.PagingAndSortingUserRepository;
import com.xschen.spring.jpa.overview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
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

    @GetMapping(path = "user")
    public List<User> getUserByName(@RequestParam("name") String name) {
        return userRepository.findByName(name);
    }

    @GetMapping(path = "singleUser")
    public List<User> getUserByNameAndEmail(@RequestParam("name") String name, @Param("email") String email) {
        return userRepository.findByNameAndEmail(name, email);
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

    @PostConstruct
    private void initData() {
        User xschen = User.builder().name("xschen").email("1638392300@qq.com").build();
        userRepository.save(xschen);
        User xiangsong = User.builder().name("xiangsong").email("474408578@qq.com").build();
        userRepository.save(xiangsong);
    }
}
