package com.think.in.spring.configuration.metadata;

import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * "users" 元素的 {@link BeanDefinitionParser} 实现
 *
 * @author xschen
 */

// 4. 自定义 BeanDefinitionParser 实现：XML 元素与 BeanDefinition 解析
public class UsersBeanDefinitionParser extends AbstractSimpleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        setPropertyValue("id", element, builder);
        setPropertyValue("name", element, builder);
        setPropertyValue("city", element, builder);
    }

    public void setPropertyValue(String attributeName, Element element, BeanDefinitionBuilder builder) {
        String attributeValue = element.getAttribute(attributeName);
        if (StringUtils.hasText(attributeValue)) {
            // <property name="id" value="1" />
            builder.addPropertyValue(attributeName, attributeValue);
        }
    }


}
