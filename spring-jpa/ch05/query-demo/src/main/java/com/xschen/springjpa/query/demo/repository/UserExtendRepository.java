package com.xschen.springjpa.query.demo.repository;

import com.xschen.springjpa.query.demo.entity.UserExtend;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xschen
 */


public interface UserExtendRepository extends JpaRepository<UserExtend, Long> {

}
