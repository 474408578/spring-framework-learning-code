package com.xschen.spring.basic_dl.e_beannames;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.stream.Stream;

/**
 * 获取IOC容器中所有的Bean
 *
 * @author xschen
 */


public class BeannamesApplication {
    public static void main(String[] args) {
        ListableBeanFactory ctx = new ClassPathXmlApplicationContext("basic_dl/quickstart-withanno.xml");
        String[] beansName = ctx.getBeanDefinitionNames();
        

        // 利用jdk1.8的Stream快速编写打印方法
        Stream.of(beansName).forEach(System.out::println);

        for (String s : beansName) {
            System.out.println(ctx.getBean(s));
        }
    }
}
