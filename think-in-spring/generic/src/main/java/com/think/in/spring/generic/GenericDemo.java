package com.think.in.spring.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Java 泛型示例
 * @author xschen
 * @date 2021/9/15 11:58
 */
public class GenericDemo {

    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        // 编译时报错
        // list.add(1);

        // 泛型擦写
        Collection temp = list;
        temp.add(1);
        System.out.println(list);
        // [Hello, World, 1]
    }
}
