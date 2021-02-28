package com.xschen.spring.jpa.repository.demo.controller;

import com.xschen.spring.jpa.repository.demo.entity.User;
import com.xschen.spring.jpa.repository.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xschen
 */

//@RestController
//@RequestMapping(value = "/api/v1")
public class UserController {

//    @Autowired
//    private UserRepository userRepository;

    /**
     * 保存用户
     * @param user
     * @return
     */
//    @PostMapping(path = "/user",
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public User addNewUser(@RequestBody User user) {
//        return userRepository.save(user);
//    }

    /**
     * 验证排序和分页查询方法，Pageable的默认实现类：PageRequest
     * @return
     */
//    @GetMapping("/page")
//    public Page<User> getAllUsersByPage() {
////        return userRepository.findAll(request);
//        return userRepository.findAll(
//                PageRequest.of(1, 20, Sort.by(new Sort.Order(Sort.Direction.ASC, "name")))
//        );
//    }

    /**
     * 排序查询方法，使用Sort对象
     * @return
     */
//    @GetMapping(path = "/sort",
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Iterable<User> getAllUserWithSort() {
//        return userRepository.findAll(
//                Sort.by(new Sort.Order(Sort.Direction.ASC, "name"))
//        );
//    }
}

