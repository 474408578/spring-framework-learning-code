package com.xschen.spring.lifecycle.e_source;

import com.xschen.spring.lifecycle.e_source.bean.Cat;
import com.xschen.spring.lifecycle.e_source.bean.Person;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xschen
 * @see AbstractApplicationContext#refresh()
 */


public class LifecycleSourceXmlApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.setConfigLocation("lifecycle/bean-source.xml"); // 保存配置文件路径

        System.out.println("=======================刷新IOC容器========================");

        ctx.refresh();

        System.out.println("=======================IOC容器刷新完毕========================");

        ctx.start();

        System.out.println("=======================IOC容器启动完成========================");

        Person person = ctx.getBean(Person.class);
        System.out.println(person);

        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);

        System.out.println("=======================准备停止IOC容器========================");

        ctx.stop();

        System.out.println("=======================IOC容器停止成功========================");

        ctx.close();
    }
}
