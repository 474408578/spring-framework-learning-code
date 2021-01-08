package com.xschen.spring.bean.b_scope.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 */

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // prototype
public class Toy {
}
