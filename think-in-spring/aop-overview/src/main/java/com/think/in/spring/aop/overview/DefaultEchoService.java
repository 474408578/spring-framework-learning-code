package com.think.in.spring.aop.overview;

import java.util.Random;

/**
 * 默认 {@link EchoService} 实现
 * @author xschen
 * @date 2021/9/13 18:22
 */

public class DefaultEchoService  implements EchoService {
    @Override
    public String echo(String message) throws Throwable {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new RuntimeException("For Purpose.");
        }
        return "[ECHO] " + message;
    }
}
