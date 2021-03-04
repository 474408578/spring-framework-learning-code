package com.xschen.springjpa.query.demo.repository;

import com.xschen.springjpa.query.demo.dto.UserDto;
import com.xschen.springjpa.query.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author xschen
 */


public interface UserDtoRepository extends JpaRepository<User, Long> {

    /**
     * 查询用户表里面的name、email和UserExtend表里面的idCard
     * @param id
     * @return
     */
    @Query("SELECT u.name, u.email, e.idCard FROM User u, UserExtend e WHERE u.id = e.userId and u.id=:id")
    List<Object[]> findByUserId(@Param("id") Long id);


    /**
     * 通过new UserDto，使用其构造方法，接收查询结果
     * @param id
     * @return
     * @see 
     */
    @Query("SELECT new com.xschen.springjpa.query.demo.dto.UserDto(CONCAT(u.name, '007'), u.email, e.idCard) " +
            "FROM User u, UserExtend e WHERE u.id = e.userId and u.id = :id")
    UserDto findByUserDtoId(@Param("id") Long id);
}
