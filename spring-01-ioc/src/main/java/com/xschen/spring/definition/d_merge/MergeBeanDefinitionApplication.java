package com.xschen.spring.definition.d_merge;

import com.xschen.spring.definition.d_merge.bean.Cat;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xschen
 */


public class MergeBeanDefinitionApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "definition/definition-merge.xml");

        Cat cat = (Cat) ctx.getBean("cat");
        System.out.println(cat);

        // getMergedBeanDefinition来自ConfigurableBeanFactory, 将本身定义的bean定义信息，与继承的bean定义信息进行合并后返回
        BeanDefinition catDefinition = ctx.getBeanFactory().getMergedBeanDefinition("cat");
        System.out.println(catDefinition);
    }
}
