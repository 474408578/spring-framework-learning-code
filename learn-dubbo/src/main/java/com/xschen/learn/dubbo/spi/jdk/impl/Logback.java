package com.xschen.learn.dubbo.spi.jdk.impl;

import com.xschen.learn.dubbo.spi.jdk.Log;

/**
 * @author xschen
 */


public class Logback implements Log {
    public void log(String info) {
        System.out.println("Logback: " + info);
    }
}
