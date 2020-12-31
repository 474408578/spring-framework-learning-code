package com.xschen.spring.lifecycle.d_prototype;

import com.xschen.spring.lifecycle.d_prototype.bean.Pen;
import com.xschen.spring.lifecycle.d_prototype.config.PrototypeLifecycleConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xschen
 *
 * todo: 原型bean的创建不随IOC的创建而创建
 *
 * 原型bean在IOC销毁时不处理destroy-method、@PreDestory、以及DisposableBean接口的实现destroy的逻辑。
 *
 * 原型bean在Bean被销毁的时候，不处理destroy-method的逻辑
 */


public class PrototypeLifecycleApplication {
    public static void main(String[] args) {
        System.out.println("准备初始化IOC容器……");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PrototypeLifecycleConfiguration.class);
        System.out.println("IOC容器初始化完成……");

        System.out.println("准备获取一个Pen");
        Pen pen = ctx.getBean(Pen.class);
        System.out.println("已经获取到了Pen");

        System.out.println("用完Pen了，准备销毁……");
        // destory-method的逻辑不会被处理
        ctx.getBeanFactory().destroyBean(pen);
        System.out.println("Pen销毁完成……");
    }

}
