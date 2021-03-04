package com.xschen.springjpa.query.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户信息扩展表
 * @author xschen
 */


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserExtend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String idCard;
    private Integer age;
    private String studentNumber;
}