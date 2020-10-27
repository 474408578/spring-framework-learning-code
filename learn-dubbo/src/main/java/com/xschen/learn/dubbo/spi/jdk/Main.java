package com.xschen.learn.dubbo.spi.jdk;


import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author xschen
 */


public class Main {
    public static void main(String[] args) {
        ServiceLoader<Log> serviceLoader = ServiceLoader.load(Log.class);

        Iterator<Log> logIterator = serviceLoader.iterator();
        while (logIterator.hasNext()) {
            Log log = logIterator.next();
            log.log("JDK SPI");
        }
    }
}
