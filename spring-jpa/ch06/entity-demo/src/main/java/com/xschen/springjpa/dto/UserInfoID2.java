package com.xschen.springjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * UserInfoID 用作联合主键类, {@link @Embeddable} 使用示例
 * @author xschen
 */


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserInfoID2 implements Serializable {
    private String name;
    private String telephone;
}