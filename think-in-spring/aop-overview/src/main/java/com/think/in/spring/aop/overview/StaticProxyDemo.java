package com.think.in.spring.aop.overview;

/**
 * 静态代理示例
 * @author xschen
 * @date 2021/9/13 18:25
 */

public class StaticProxyDemo {

    public static void main(String[] args) {
        EchoService echoService = new ProxyEchoService(new DefaultEchoService());
        echoService.echo("Hello, World");
    }
}
