package com.xschen.spring.proxy.a_basic;

/**
 * @author xschen
 */


public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
