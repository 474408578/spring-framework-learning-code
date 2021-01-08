package com.xschen.spring.bean.b_scope;

import com.xschen.spring.bean.b_scope.bean.Child;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xschen
 */


public class BeanScopeXmlApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean/bean-scope.xml");
        ctx.getBeansOfType(Child.class).forEach((name, child) -> {
            System.out.println(name + ": " + child);
        });
    }

}
