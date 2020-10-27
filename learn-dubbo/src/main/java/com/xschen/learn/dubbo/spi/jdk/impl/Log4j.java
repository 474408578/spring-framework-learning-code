package com.xschen.learn.dubbo.spi.jdk.impl;

import com.xschen.learn.dubbo.spi.jdk.Log;

/**
 * @author xschen
 */


public class Log4j implements Log {
    public void log(String info) {
        System.out.println("Log4j: " + info);
    }
}
