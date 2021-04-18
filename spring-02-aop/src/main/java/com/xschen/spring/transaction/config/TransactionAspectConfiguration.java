package com.xschen.spring.transaction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author xschen
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.xschen.spring.transaction")
public class TransactionAspectConfiguration {

}
