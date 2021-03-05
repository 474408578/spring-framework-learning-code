package com.xschen.springjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * UserInfoID 用作联合主键类, {@link IdClass} 使用示例
 * @author xschen
 */


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoID implements Serializable {
    private String name;
    private String telephone;
}