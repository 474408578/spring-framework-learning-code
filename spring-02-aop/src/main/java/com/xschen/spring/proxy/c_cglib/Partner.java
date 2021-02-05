package com.xschen.spring.proxy.c_cglib;



/**
 * 被cglib代理的类Partner, 不能是 final 的（ Cglib 动态代理会创建子类，final 类型的 Class 无法继承）
 * 被代理的类必须有默认的 / 无参构造方法（底层反射创建对象时拿不到构造方法参数）。
 * @author xschen
 */


public class Partner {

    private String name;

    public Partner() {
    }

    public Partner(String name) {
        this.name = name;
    }


    public void receiveMoney(int money) {
        System.out.println(name + "收到佣金：" + money + "元~");
    }

    public void playWith(Player player) {
        System.out.println(name + "与" + player.getName() + "一起愉快地玩耍");
    }
}
