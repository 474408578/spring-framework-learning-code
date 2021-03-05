package com.xschen.springjpa.entity;

import com.xschen.springjpa.dto.UserInfoID;
import com.xschen.springjpa.dto.UserInfoID2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;

/**
 * {@link EmbeddedId} 使用示例
 * 此时的主键: primary key (name, telephone)
 * @author xschen
 */

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo2 {
    @EmbeddedId
    private UserInfoID2 userInfoID2;
    private Integer age;
}
