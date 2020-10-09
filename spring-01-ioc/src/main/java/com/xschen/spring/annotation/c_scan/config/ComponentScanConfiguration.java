package com.xschen.spring.annotation.c_scan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 * 在配置类上标注一个@ComponentScan，并指定要扫描的路径，
 * 他就可以扫描指定路径下的包及其子包下的所有@Component组件
 */

@Configuration
@ComponentScan("com.xschen.spring.annotation.c_scan.bean")
public class ComponentScanConfiguration {

}
