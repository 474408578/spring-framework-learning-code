package com.think.in.spring.conversion;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyEditor;

/**
 * Spring 自定义 {@link PropertyEditor} 示例
 * @author xschen
 */

public class SpringCustomizedPropertyEditorDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/property-editors-context.xml");

        // AbstractApplicationContext#refresh() -> finishBeanFactoryInitialization()
        // -> ConfigurableBeanFactory#setConversionService(conversionService)

        User user = context.getBean("user", User.class);
        System.out.println(user);
        context.close();

    }
}
