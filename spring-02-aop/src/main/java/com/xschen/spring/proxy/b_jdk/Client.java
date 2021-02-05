package com.xschen.spring.proxy.b_jdk;

/**
 * @author xschen
 */


public class Client {

    public static void main(String[] args) {
        Player player = new Player("郝武辽");
        Partner partner = PartnerPlatform.getPartner(50);

        partner.receiveMoney(50);
        partner.playWith(player);
    }
}
