package com.xschen.spring.jpa.repository.demo.repository;

import com.xschen.spring.jpa.repository.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author xschen
 */

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmailAddress(String emailAddress);
}
