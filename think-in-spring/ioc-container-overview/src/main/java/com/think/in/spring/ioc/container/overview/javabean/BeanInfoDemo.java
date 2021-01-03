package com.think.in.spring.ioc.container.overview.javabean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * {@link  java.beans.BeanInfo} 示例
 * @author xschen
 *
 *
 */


public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    System.out.println(propertyDescriptor);
                    // PropertyDescriptor 允许添加属性编辑器 - PropertyEditor
                    // GUI text(String) -> PropertyType
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    String proertyName = propertyDescriptor.getName();
                    if ("age".equals(proertyName)) { // 为 "age"字段/属性增加PropertyEditor
                        // String -> Integer
//                        Integer.valueOf("")
                        propertyDescriptor.setPropertyEditorClass(StringtoIntegerPropertyEditor.class);
//                        propertyDescriptor.createPropertyEditor()
                    }
                });
    }

    static class StringtoIntegerPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value); // 给getValue操作
        }
    }
}

