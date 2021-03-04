package com.xschen.springjpa.query.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 利用 class UserDto 获取我们想要的结果
 * @author xschen
 */

@Data
@Builder
@AllArgsConstructor
public class UserDto {

    private String name;
    private String email;
    private String idCard;
}
