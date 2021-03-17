package com.xschen.spring.jpa.overview.ch1_6.domain;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Entity 对象 RedBook 指向 Book 这张表
 * @author xschen
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("red") // Book 中的 color 字段
public class RedBook extends Book {
    private String redMark;
}
