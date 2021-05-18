package com.think.in.spring.conversion;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyEditor;

/**
 * Spring 自定义 {@link PropertyEditor} 示例
 * @author xschen
 */

public class SpringCustomizedPropertyEditorDemo {

    public static void main(String[] args) {
        // 创建并启动 BeanFactory 容器
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("META-INF/property-editors-context.xml");

        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
        applicationContext.close();

    }
}
