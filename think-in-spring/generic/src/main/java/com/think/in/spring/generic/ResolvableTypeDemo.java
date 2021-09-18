package com.think.in.spring.generic;

import org.springframework.core.ResolvableType;

/**
 * {@link ResolvableType} 示例
 * @author xschen
 * @date 2021/9/16 11:32
 * 工厂方法 for*
 * 转换方法 as*
 * 处理方法 resolve*
 */


public class ResolvableTypeDemo {

    public static void main(String[] args) {
        // StringList <- ArrayList <- AbstractList <- AbstractCollection
        ResolvableType resolvableType = ResolvableType.forClass(StringList.class);
        resolvableType.getSuperType().getSuperType().getSuperType(); // AbstractCollection

        // 获取 Raw Type：Collection
        System.out.println(resolvableType.asCollection().resolve());

        // 获取泛型参数类型：String
        System.out.println(resolvableType.asCollection().resolveGeneric(0));
    }
}
