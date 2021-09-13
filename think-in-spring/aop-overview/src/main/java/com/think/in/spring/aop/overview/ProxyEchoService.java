package com.think.in.spring.aop.overview;

/**
 * @author xschen
 * @date 2021/9/13 18:26
 */

public class ProxyEchoService implements EchoService {
    private final EchoService echoService;

    public ProxyEchoService(EchoService echoService) {
        this.echoService = echoService;
    }

    @Override
    public String echo(String message) {
        long startTime = System.currentTimeMillis();
        String result = echoService.echo(message);
        long costTime = System.currentTimeMillis() - startTime;
        System.out.println("echo execute cost : " + costTime + " ms.");
        return echoService.echo(message);
    }
}
