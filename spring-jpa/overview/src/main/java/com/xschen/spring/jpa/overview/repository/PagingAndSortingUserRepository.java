package com.xschen.spring.jpa.overview.repository;

import com.xschen.spring.jpa.overview.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author xschen
 */
public interface PagingAndSortingUserRepository extends PagingAndSortingRepository<User, Long> {

}

