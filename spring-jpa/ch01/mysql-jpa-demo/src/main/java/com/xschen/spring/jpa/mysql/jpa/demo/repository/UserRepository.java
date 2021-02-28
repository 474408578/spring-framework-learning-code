package com.xschen.spring.jpa.mysql.jpa.demo.repository;


import com.xschen.spring.jpa.mysql.jpa.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xschen
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
