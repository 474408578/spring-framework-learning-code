package com.think.in.spring.bean.lifecycle;

import com.think.in.spring.ioc.container.overview.domain.SuperUser;
import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Bean 实例化 声明周期示例
 * @author xschen
 */
public class BeanInstantiationLifecycleDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 添加 BeanPostProcessor
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] locations = {"META-INF/bean-constructor-dependency-injection.xml", "META-INF/dependency-lookup-context.xml"};
        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(locations);
        System.out.println("已加载的 BeanDefinition 数量：" + beanNumbers);
        // 通过Bean id 和类型进行 依赖查找
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
        User superUser = beanFactory.getBean("superUser", User.class);
        System.out.println(superUser);

        // 构造器注入按照类型注入， ResolveDependency
        UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
        System.out.println(userHolder);
    }

    static class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            // 把配置完成的 superUser 覆盖
//            if ("superUser".equals(beanName)) {
//                return new SuperUser();
//            }
            // 保持不变，Spring有兜底机制
            // AbstractAutowireCapableBeanFactory#applyBeanPostProcessorsBeforeInitialization
            return null;
        }

        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            if ("user".equals(beanName)) { // user对象不允许属性赋值（填入），（配置元信息 --> 属性值）
                User user = (User) bean;
                user.setId(2L);
                user.setName("songsong");
                return false;
            }
            return true;
        }
    }
}
