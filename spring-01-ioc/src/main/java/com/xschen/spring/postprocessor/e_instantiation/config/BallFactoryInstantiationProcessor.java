package com.xschen.spring.postprocessor.e_instantiation.config;

import com.xschen.spring.postprocessor.e_instantiation.bean.Ball;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */


public class BallFactoryInstantiationProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        if (Ball.class.equals(beanClass)) {
        if ("ball".equals(beanName)) {
            Ball ball = new Ball();
            ball.setId("工厂球");
            return ball;
        }

        // 默认直接返回null，代表不拦截
        return null;
    }

    // 返回true，则执行postProcessProperties方法，否则不执行
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    // 如果bean被postProcessBeforeInstantiation方法执行后，就不会再执行postProcessProperties。
    // 也就是postProcessProperties方法没有机会再影响postProcessBeforeInstantiation方法创建出来的对象。
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if ("ball2".equals(beanName)) {
            MutablePropertyValues values = new MutablePropertyValues(pvs);
            values.addPropertyValue("id", "拦截球");
            return values;
        }
        return null;
    }
}
