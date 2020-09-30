package com.xschen.architecture.d_properties.factory;

import com.xschen.architecture.d_properties.dao.DemoDao;

import java.io.IOException;
import java.util.Properties;

/**
 * @author xschen
 */


public class BeanFactory {
    private static Properties properties;
    static {
        properties = new Properties();

        try {
            // 必须使用类加载器读取resource文件夹下的配置文件
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory.properties"));
        } catch (IOException e) {
            // BeanFactory类的初始化都失败了，那后续就没有必要再执行下去了
            throw new ExceptionInInitializerError("BeanFactory initialize error, cause" + e.getMessage());
        }
    }

    public static Object getBean(String beanName) {
        try {
            // 从properties文件中读取指定name对应类的全限定类名，并反射实例化
            Class<?> beanClazz = Class.forName(properties.getProperty(beanName));
            return beanClazz.newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("BeanFactory have not [" + beanName + "] bean!", e);
        } catch (IllegalAccessException |InstantiationException e) {
            throw new RuntimeException("[" + beanName + "] instantiation error!", e);
        }
    }
}
