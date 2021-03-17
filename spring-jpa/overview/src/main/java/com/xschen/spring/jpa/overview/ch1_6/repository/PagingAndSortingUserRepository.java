package com.xschen.spring.jpa.overview.ch1_6.repository;

import com.xschen.spring.jpa.overview.ch1_6.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author xschen
 */
public interface PagingAndSortingUserRepository extends PagingAndSortingRepository<User, Long> {

}

