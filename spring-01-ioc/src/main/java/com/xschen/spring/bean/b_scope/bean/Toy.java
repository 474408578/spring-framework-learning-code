package com.xschen.spring.bean.b_scope.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
//@Scope("prototype") // 每次获取都创建一个bean实例，不指定默认为单例(Singleton)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // prototype
public class Toy {
}
