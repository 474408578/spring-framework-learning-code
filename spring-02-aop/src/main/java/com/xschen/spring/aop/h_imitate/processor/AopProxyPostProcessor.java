package com.xschen.spring.aop.h_imitate.processor;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.aspectj.lang.annotation.*;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xschen
 */

@Component
public class AopProxyPostProcessor implements BeanPostProcessor, BeanFactoryAware {
    private ConfigurableListableBeanFactory beanFactory;
    /**
     * 只实现了 @Before 注解
     */
    protected static Map<PointcutExpression, Method> beforePointcutExpMethodMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void initAspectAndPointcuts() {
        // 获取 BeanFactory 中所有的 BeanDefinition
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        // 检查BeanDefinition对应的class上是否标注了@Aspect注解
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
            String beanClassName = beanDefinition.getBeanClassName();
            if (!StringUtils.hasText(beanClassName)) {
                continue;
            }

            Class<?> clazz = ClassUtils.resolveClassName(beanClassName, ClassUtils.getDefaultClassLoader());
            if (!clazz.isAnnotationPresent(Aspect.class)) {
                continue;
            }
            // 到此为止，说明当前BeanDefinition对应的bean是一个切面类
            /**
             * 解析方法及切入表达式
             */
            ReflectionUtils.doWithMethods(clazz, new MyMethodCallback(), new MyMethodFilter());
        }
    }

    /**
     * 实现切入点表达式的解析，存入 beforePointcutExpMethodMap 中
     */
    public static class MyMethodCallback implements ReflectionUtils.MethodCallback {
        private static PointcutParser pointcutParser = PointcutParser
                .getPointcutParserSupportingAllPrimitivesAndUsingContextClassloaderForResolution();
        @Override
        public void doWith(Method method) throws IllegalArgumentException {
            Before before = method.getAnnotation(Before.class);
            if (before != null) {
                String pointcutExp = before.value();
                PointcutExpression pointcutExpression = pointcutParser.parsePointcutExpression(pointcutExp);
                beforePointcutExpMethodMap.put(pointcutExpression, method);
            }
        }
    }

    /**
     * 过滤出通知方法
     */
    public static class MyMethodFilter implements ReflectionUtils.MethodFilter {
        @Override
        public boolean matches(Method method) {
            return method.isAnnotationPresent(Before.class)
                    || method.isAnnotationPresent(After.class)
                    || method.isAnnotationPresent(AfterReturning.class)
                    || method.isAnnotationPresent(AfterThrowing.class)
                    || method.isAnnotationPresent(Around.class);
        }
    }


    /**
     * 生成代理对象
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 切面类不增强
        if (bean.getClass().isAnnotationPresent(Aspect.class)) {
            return bean;
        }

        List<Method> proxyMethods = new ArrayList<>();
        beforePointcutExpMethodMap.forEach(((pointcutExpression, method) -> {
            if (pointcutExpression.couldMatchJoinPointsInType(bean.getClass())) {
                proxyMethods.add(method);
            }
        }));

        // 没有能匹配的切面，则直接返回普通对象
        if (proxyMethods.isEmpty()) {
            return bean;
        }
        // 需要织入通知
        return Enhancer.create(bean.getClass(), (MethodInterceptor) (proxy, method, args, methodProxy) -> {
            // 依次执行前置通知
            for (Method proxyMethod : proxyMethods) {
                Object aspectBean = beanFactory.getBean(proxyMethod.getDeclaringClass());
                proxyMethod.invoke(aspectBean);
            }

            return methodProxy.invokeSuper(proxy, args);
        });
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        // 强转为比较高级的类型，方便接下来拿 BeanDefinition
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }
}
