package com.think.in.spring.generic;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Java 泛型API示例
 * @author xschen
 * @date 2021/9/15 12:01
 * @see Class Java类API
 * @see GenericArrayType 泛型数组类型
 * @see ParameterizedType 泛型参数类型
 * @see TypeVariable 泛型类型变量，如Collection<E> 中的 E
 * @see WildcardType 泛型通配类型
 */

public class GenericApiDemo {

    public static void main(String[] args) {
        // 原生类型 primitive types : int long float
        Class intClazz = int.class;

        // 数组类型 array types : int[], Object[]
        Class objectArrayClazz = Object[].class;

        // 原始类型 raw types: java.lang.String）（final 类）
        Class rawClass = String.class;

        // 泛型参数类型 parameterized type
        ParameterizedType parameterizedType = (ParameterizedType) ArrayList.class.getGenericSuperclass();
        System.out.println(parameterizedType.toString()); // java.util.AbstractList<E>
        System.out.println(parameterizedType.getRawType()); // class java.util.AbstractList

        // 泛型变量
        Type[] typeArguments = parameterizedType.getActualTypeArguments(); // E
        Stream.of(typeArguments)
                .map(TypeVariable.class::cast) // 强转
                .forEach(System.out::println);
    }
}
