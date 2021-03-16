package com.xschen.spring.jpa.overview.repository;

import com.xschen.spring.jpa.overview.domain.UserExtend;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xschen
 */
public interface UserExtendRepository extends JpaRepository<UserExtend, Long> {
}
