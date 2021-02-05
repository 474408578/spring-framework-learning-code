package com.xschen.spring.proxy.a_basic;

/**
 * @author xschen
 */


public class Client {

    public static void main(String[] args) {
        Player player = new Player("郝武辽");
        Partner partner = new Partner("肖婕婕");

        partner.receiveMoney(200);
        partner.playWith(player);
    }
}
