package com.xschen.springjpa.repository;

import com.xschen.springjpa.dto.UserInfoID2;
import com.xschen.springjpa.entity.UserInfo2;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xschen
 */


public interface UserInfoRepository2 extends JpaRepository<UserInfo2, UserInfoID2> {
}
