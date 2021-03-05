package com.xschen.springjpa.entity;

import com.xschen.springjpa.dto.UserInfoID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * {@link IdClass} 使用示例
 * 此时的主键: primary key (name, telephone)
 * @author xschen
 */

@Entity
@Data
@Builder
@IdClass(UserInfoID.class) // 采用@IdClass引用联合主键类
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Integer age;
    @Id
    private String name;
    @Id
    private String telephone;
}
