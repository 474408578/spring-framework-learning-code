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

        // 下面的代码会报Bean没有定义 NoSuchBeanDefinitionException
        // Dog dog = ctx.getBean(Dog.class);

        // xml文件内没有定义dog，这一行不会报错
        ObjectProvider<Dog> dogProvider = ctx.getBeanProvider(Dog.class);
        // 只有当执行getObject方法时才会检查是否存在，即实现了延迟查找
//        System.out.println(dogProvider.getObject());

        // jdk1.8后，ObjectProvider接口有了新扩展：借助Supplier接口返回缺省创建
//        Dog defaultDog = dogProvider.getIfAvailable(()-> new Dog());
        // 也可以使用方法引用创建Dog
        Dog defaultDog = dogProvider.getIfAvailable(Dog::new);
        System.out.println(defaultDog);


        // 只有bean存在才会执行Consumer接口的方法
        dogProvider.ifAvailable(System.out::println);
    }
}
