package com.xschen.springjpa.repository;

import com.xschen.springjpa.entity.UserInfo;
import com.xschen.springjpa.dto.UserInfoID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xschen
 */


public interface UserInfoRepository extends JpaRepository<UserInfo, UserInfoID> {
}
