package com.xschen.spring.jpa.overview.repository;

import com.xschen.spring.jpa.overview.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author xschen
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);
    List<User> findByNameAndEmail(String name, String email);
}
