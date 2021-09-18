package com.think.in.spring.generic;

import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * {@link GenericTypeResolver} Spring泛型类型辅助类 示例
 * @author xschen
 * @date 2021/9/16 10:02
 * @see GenericTypeResolver
 */

public class GenericTypeResolverDemo {

    public static void main(String[] args) throws NoSuchMethodException {
        // String 是 Comparable<String> 具体化; class java.lang.String, class java.lang.String
        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class, Comparable.class, "getString");

        // ArrayList<Object> 是 List 泛型的参数类型 具体化; class java.util.ArrayList, class java.lang.Object
        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class, List.class, "getList");

        // 没有对 List 泛型的参数类型进行具体化; class java.util.ArrayList, null
        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class, List.class, "getAbstractGenericList");

        // StringList 也是 List 泛型参数类型的具体化; class com.think.in.spring.generic.GenericTypeResolverDemo$StringList, class java.lang.String
        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class, List.class, "getStringList");

        // TypeVariable
        Map<TypeVariable, Type> typeVariableTypeMap = GenericTypeResolver.getTypeVariableMap(StringList.class);
        // {E=class java.lang.String, E=class java.lang.String, E=class java.lang.String, E=class java.lang.String, E=class java.lang.String, T=class java.lang.String}

        System.out.println(typeVariableTypeMap);
    }


    private static void displayReturnTypeGenericInfo(Class<?> containingClass,
                                                     Class<?> genericInterface,
                                                     String methodName,
                                                     Class... argsTypes) throws NoSuchMethodException {
        Method method = containingClass.getMethod(methodName);
        Class<?> returnType = GenericTypeResolver.resolveReturnType(method, containingClass);
        System.out.printf("GenericTypeResolver.resolverReturnType(%s, %s) = %s\n", methodName, containingClass.getSimpleName(), returnType);
        Class<?> returnTypeArgument = GenericTypeResolver.resolveReturnTypeArgument(method, genericInterface);
        System.out.printf("GenericTypeResolver.resolverReturnTypeArgument(%s, %s) = %s\n", methodName, containingClass.getSimpleName(), returnTypeArgument);
    }

    public static String getString() {
        return null;
    }

    public static ArrayList<Object> getList() { // 泛型参数具体化
        return null;
    }

    public static <T> ArrayList<T> getAbstractGenericList() {
        return null;
    }

    public static StringList getStringList() {
        return null;
    }
}
