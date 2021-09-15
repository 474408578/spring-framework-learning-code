package com.xschen.spring.event.d_payload;

import com.xschen.spring.annotation.b_di.bean.Person;
import com.xschen.spring.event.d_payload.component.PayLoadIntegerApplicationListener;
import com.xschen.spring.event.d_payload.component.PayLoadObjectApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 * @see PayloadApplicationEvent 无需定义时间，泛型
 */


public class PayLoadEventApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.addApplicationListener(new PayLoadObjectApplicationListener());
        ctx.addApplicationListener(new PayLoadIntegerApplicationListener());

        ctx.refresh();
        ctx.publishEvent("hahha");
        ctx.publishEvent(123456789);
        ctx.publishEvent(new Person());
    }
}
