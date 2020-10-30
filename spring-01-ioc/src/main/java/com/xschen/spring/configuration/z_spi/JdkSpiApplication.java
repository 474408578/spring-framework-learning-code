package com.xschen.spring.configuration.z_spi;

import com.xschen.spring.configuration.z_spi.bean.DemoDao;

import java.util.ServiceLoader;

/**
 * @author xschen
 * jdk原生的SPI需要遵循规范的：所有定义的SPI文件都必须放在工程的META-INF/services目录下，
 * 且文件名必须命名为接口/抽象类的全限定类名，文件内容为接口/抽象类的具体实现类的全限定类名。
 * 如果出现多个具体实现类，则每行声明一个类的全限定类名，没有分隔符
 *
 */


public class JdkSpiApplication {

    public static void main(String[] args) {
        ServiceLoader<DemoDao> serviceLoader = ServiceLoader.load(DemoDao.class);
        serviceLoader.iterator().forEachRemaining(demoDao -> {
            System.out.println(demoDao.toString());
        });
    }
}
