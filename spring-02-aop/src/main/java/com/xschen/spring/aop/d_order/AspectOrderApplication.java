package com.xschen.spring.aop.d_order;

import com.xschen.spring.aop.d_order.config.AspectOrderConfiguration;
import com.xschen.spring.aop.d_order.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 多个切面的执行顺序，默认切面的顺序，是根据切面类的 unicode 编码，按照十六进制排序得来的，unicode 编码靠前的，那自然就会排在前面
 * @author xschen
 */


public class AspectOrderApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AspectOrderConfiguration.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.saveUser("abc");
    }
}
