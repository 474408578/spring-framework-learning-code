package com.xschen.spring.event.e_source;

import com.xschen.spring.event.a_quickstart.listener.ContextRefreshedApplicationListener;
import org.springframework.core.ResolvableType;

/**
 * {@link ResolvableType} 示例
 * @author xschen
 *
 * @see ResolvableType 可以方便地解析、获取到指定类、属性、方法中的泛型类型。（只能简化操作，并不能在Java原生的反射上做更多的事情）
 */


public class ResolvableTypeApplication {

    public static void main(String[] args) {
        ResolvableType resolvableType = ResolvableType.forClass(ContextRefreshedApplicationListener.class);
        // 取出第一个接口的泛型类型
        System.out.println(resolvableType.getInterfaces()[0].resolveGeneric(0));

    }
}
