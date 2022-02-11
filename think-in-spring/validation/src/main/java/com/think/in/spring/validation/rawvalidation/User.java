package com.think.in.spring.validation.rawvalidation;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author xschen
 * @date 2022/2/11 17:06
 */

@Data
@Builder
public class User {
    @NotNull
    private String name;
    @Length(min = 10)
    @NotNull
    private String fullName;
}
