package com.xschen.spring.jpa.hello.world;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xschen
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
