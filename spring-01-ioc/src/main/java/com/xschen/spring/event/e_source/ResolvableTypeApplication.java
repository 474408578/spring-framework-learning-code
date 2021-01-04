package com.xschen.spring.event.e_source;

import com.xschen.spring.event.a_quickstart.listener.ContextRefreshedApplicationListener;
import org.springframework.core.ResolvableType;

/**
 * @author xschen
 */


public class ResolvableTypeApplication {

    public static void main(String[] args) {
        ResolvableType resolvableType = ResolvableType.forClass(ContextRefreshedApplicationListener.class);
        System.out.println(resolvableType.getInterfaces()[0].resolveGeneric(0));

    }
}
