package com.xschen.springjpa.query.demo.repository;

import com.xschen.springjpa.query.demo.dto.UserDto;
import com.xschen.springjpa.query.demo.dto.UserOnlyNameAndEmailDto;
import com.xschen.springjpa.query.demo.dto.UserSimpleDto;
import com.xschen.springjpa.query.demo.entity.User;
import org.hibernate.query.criteria.internal.expression.function.ParameterizedFunctionExpression;
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
    @Query("SELECT u.name, u.email, e.idCard FROM User u, UserExtend e WHERE u.id = e.userId AND u.id=:id")
    List<Object[]> findByUserId(@Param("id") Long id);


    /**
     * 通过new UserDto，使用其构造方法，接收查询结果
     * @param id
     * @return
     * @see ParameterizedFunctionExpression
     */
    @Query("SELECT new com.xschen.springjpa.query.demo.dto.UserDto(CONCAT(u.name, '007'), u.email, e.idCard) " +
            "FROM User u, UserExtend e WHERE u.id = e.userId AND u.id = :id")
    UserDto findByUserDtoId(@Param("id") Long id);

    /**
     * 利用接口 DTO 获得返回结果，需要注意的是每个字段需要 as 和接口里面的 get 方法名字保持一样
     * @param id
     * @return
     */
    @Query("SELECT CONCAT(u.name, '007') AS name, UPPER(u.email) AS email, e.idCard AS idCard FROM User u, " +
            "UserExtend e WHERE u.id = e.userId AND u.id = :id")
    UserSimpleDto findByUserSimpleDtoId(@Param("id") Long id);

    /**
     * 利用JQPl动态查询用户信息
     * @param name
     * @param email
     * @return
     */
    @Query("SELECT u.name AS name, u.email AS email FROM User u WHERE (:name is null OR name = :name) AND " +
            "(:email is null OR email = :email)")
    UserOnlyNameAndEmailDto findByUser(@Param("name") String name, @Param("email") String email);

    /**
     * 利用原始 SQL 动态查询用户信息
     * @return
     */
    @Query(value = "SELECT u.name AS name, u.email AS email " +
            "FROM user u WHERE (:#{#user.name} is null OR u.name = :#{#user.name}) " +
            "AND (:#{#user.email} is null OR u.email = :#{#user.email})", nativeQuery = true)
    UserOnlyNameAndEmailDto findByUserNature(@Param("user") User user);
}
