package com.xschen.architecture.j_staticproxy.factory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author xschen
 */


public class BeanFactory {
    private static Map<String, Object> beanMap = new HashMap<>();
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory_j.properties"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError("BeanFactory initialize error, cause: " + e.getMessage());
        }
    }

    public static Object getBean(String beanName) {
        if (!beanMap.containsKey(beanName)) {
            synchronized (BeanFactory.class) {
                if (!beanMap.containsKey(beanName)) {
                    try {
                        Class<?> beanClazz = Class.forName(properties.getProperty(beanName));
                        Constructor constructor = beanClazz.getConstructor();
                        Object bean = constructor.newInstance();
                        beanMap.put(beanName, bean);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException("BeanFactory have not [" + beanName + "] bean!", e);
                    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        throw new RuntimeException("[" + beanName + "] initialize error!", e);
                    }
                }
            }
        }

        return beanMap.get(beanName);
    }


}
