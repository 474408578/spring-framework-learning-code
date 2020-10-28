package com.xschen.spring.postprocessor.f_destruction.config;

import com.xschen.spring.postprocessor.f_destruction.bean.Pen;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 *
 * Spring中的DestructionAwareBeanPostProcessor：在Spring中主要用作监听器的引用释放回调。
 * 由于ApplicationContext中会注册一些ApplicationListener，而这些ApplicationListener与ApplicationContext
 * 互相引用，所以在IOC容器销毁之前，就需要将这些引用断开，这样才可以进行对象的销毁和回收
 */

@Component
public class DestructionPenPostProcessor implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String s) throws BeansException {
        if (bean instanceof Pen) {
            System.out.println("DestructionPenPostProcessor postProcessBeforeDestruction run ……");
            Pen pen = (Pen) bean;
            pen.setInk(0);
        }
    }
}
