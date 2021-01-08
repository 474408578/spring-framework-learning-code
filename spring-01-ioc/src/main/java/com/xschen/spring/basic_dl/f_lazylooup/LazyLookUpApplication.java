package com.xschen.spring.basic_dl.f_lazylooup;

import com.xschen.spring.basic_dl.f_lazylooup.beans.Cat;
import com.xschen.spring.basic_dl.f_lazylooup.beans.Dog;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xschen
 * todo: 依赖查找，延迟加载
 * ObjectProvider实现延迟查找
 */


public class LazyLookUpApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basic_dl/quickstart-lazylookup.xml");
        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);

        // 获取到ObjectProvider
        ObjectProvider<Dog> dogProvider = ctx.getBeanProvider(Dog.class);
        // 只有当执行getObject方法时才会检查是否存在，即实现了延迟查找
        // System.out.println(dogProvider.getObject());

        // jdk1.8后，ObjectProvider接口有了新扩展：借助Supplier接口返回缺省创建
        Dog defaultDog = dogProvider.getIfAvailable(Dog::new);
        System.out.println(defaultDog);


        // 只有bean存在于IOC容器中才会执行Consumer接口的方法
        dogProvider.ifAvailable(System.out::println);
    }
}
