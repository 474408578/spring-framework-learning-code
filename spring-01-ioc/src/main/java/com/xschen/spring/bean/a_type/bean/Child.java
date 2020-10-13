package com.xschen.spring.bean.a_type.bean;

/**
 * @author xschen
 */


public class Child {
    private String wantToy = "ball";

    public String getWantToy() {
        return wantToy;
    }

    @Override
    public String toString() {
        return "Child{" +
                "wantToy='" + wantToy + '\'' +
                '}';
    }
}
