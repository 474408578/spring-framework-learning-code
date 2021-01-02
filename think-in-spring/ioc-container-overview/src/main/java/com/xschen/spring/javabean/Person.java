package com.xschen.spring.javabean;

/**
 * @author xschen
 * JavaBean是一种综合需求的基础，简单地说，它包含了Bean自省（Bean内部描述），
 * Bean时间，Bean的内容修改（编辑）等，并且由BeanContext统一托管Bean示例，
 * 简单地说，Spring有部分思想是借鉴了JavaBean
 *
 * todo: 描述人的POJO
 *
 * Setter / Getter
 * Writable / Readable
 */


public class Person {

    // String to String
    String name; // Property

    // String to Integer
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
