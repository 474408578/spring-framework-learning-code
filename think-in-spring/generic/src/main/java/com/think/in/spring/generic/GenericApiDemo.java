package com.think.in.spring.generic;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

/**
 * Java 泛型API示例
 * @author xschen
 * @date 2021/9/15 12:01
 * @see ParameterizedType 泛型参数类型
 * @see GenericArrayType 泛型数组类型
 *
 */

public class GenericApiDemo {

    public static void main(String[] args) {
        // 原生类型 primitive types : int long float
        Class intClazz = int.class;

        // 数组类型 array types : int[], Object[]
        Class objectArrayClazz = Object[].class;

        // 原始类型 raw types: java.lang.String
        Class rawClass = String.class;

        // 泛型参数类型 parameterized type
        ParameterizedType parameterizedType = (ParameterizedType) ArrayList.class.getGenericSuperclass();
        System.out.println(parameterizedType.toString());
    }
}
