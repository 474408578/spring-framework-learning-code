package com.xschen.spring.lifecycle.a_initmethod;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xschen
 *
 * Bean的生命周期
 * 实例化--> init --> 程序运行期  --> destory --> finalize
 * 一个对象从被创建，到被垃圾回收，可以宏观的划分为 5 个阶段：
 *
 * 创建 / 实例化阶段：此时会调用类的构造方法，产生一个新的对象
 * 初始化阶段：此时对象已经创建好，但还没有被正式使用，可能这里面需要做一些额外的操作（如预初始化数据库的连接池）
 * 运行使用期：此时对象已经完全初始化好，程序正常运行，对象被使用
 * 销毁阶段：此时对象准备被销毁，已不再使用，需要预先的把自身占用的资源等处理好（如关闭、释放数据库连接）
 * 回收阶段：此时对象已经完全没有被引用了，被垃圾回收器回收
 */


public class InitMethodXmlApplcation {
    public static void main(String[] args) {
        System.out.println("准备初始化IOC容器……");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("lifecycle/bean-initmethod.xml");
        System.out.println("IOC容器初始化完成……\n");

        System.out.println("准备销毁IOC容器……");
        ctx.close();
        System.out.println("IOC容器销毁完成……");

    }
}
