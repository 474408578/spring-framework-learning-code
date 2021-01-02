package com.xschen.architecture.e_cachedfactory.factory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author xschen
 *
 * 带缓存的BeanFactory，保证bean的唯一性
 */


public class BeanFactory {
    private static Map<String, Object> beanMap = new HashMap<>();

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory_e.properties"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError("BeanFactory initialize error, cause: " + e.getMessage());
        }
    }

    public static Object getBean(String beanName) {
        // 双检锁保证beanMap中确实没有beanName对应的对象，有点类似单例
        if (!beanMap.containsKey(beanName)) {
            synchronized (BeanFactory.class) {
                if (!beanMap.containsKey(beanName)) {
                    try {
                        // 过了双检锁，确认没有，可以执行反射来创建
                        Class<?> beanClazz = Class.forName(properties.getProperty(beanName));
                        Object bean = beanClazz.newInstance();
                        // 反射创建好之后，放入缓存之后再返回
                        beanMap.put(beanName, bean);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException("BeanFactory have not [" + beanName + "] bean!", e);
                    } catch (InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException("[" + beanName + "] initialize error!", e);
                    }
                }
            }
        }
        return beanMap.get(beanName);
    }
}
