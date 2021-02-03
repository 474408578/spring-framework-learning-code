package com.xschen.architecture.m_proxyfactory.factory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
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
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("factory_m.properties"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError("BeanFactory Initialize error, cause: " + e.getMessage());
        }

    }

    public static Object getBean(String beanName) {
        if (!beanMap.containsKey(beanName)) {
            synchronized (BeanFactory.class) {
                if (!beanMap.containsKey(beanName)) {
                    try {
                        Class<?> clazz = Class.forName(properties.getProperty(beanName));
                        Constructor constructor = clazz.getDeclaredConstructor();
                        Object bean = constructor.newInstance();
                        // 检查properties 是否有定义代理增强
                        String proxyAdvisorClassName = properties.getProperty(beanName + "proxy.class");
                        if (proxyAdvisorClassName != null && proxyAdvisorClassName.trim().length() > 0) {
                            Class<?> proxyAdvisorClass = Class.forName(proxyAdvisorClassName);
                            String[] methods = properties.getProperty(beanName + "proxy.method").split(",");
                            InvocationHandler proxyHandler = (InvocationHandler) proxyAdvisorClass.getConstructors()[0]
                                    .newInstance(bean, methods);
                            // 动态代理创建对象
                            Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                                    bean.getClass().getInterfaces(),
                                    proxyHandler);
                            bean = proxy;
                        }
                        beanMap.put(beanName, bean);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException("BeanFactory have not [ " + beanName + " ] bean!", e);
                    } catch (NoSuchMethodException | IllegalAccessException |InstantiationException | InvocationTargetException e) {
                        throw new RuntimeException("[ " + beanName + " ] initialize error", e);
                    }
                }
            }
        }
        return beanMap.get(beanName);
    }
}
