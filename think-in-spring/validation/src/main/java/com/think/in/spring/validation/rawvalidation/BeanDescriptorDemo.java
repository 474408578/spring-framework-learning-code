package com.think.in.spring.validation.rawvalidation;

import javax.validation.metadata.*;

import java.util.Set;

import static com.think.in.spring.validation.rawvalidation.ValidatorUtil.*;

/**
 * {@link BeanDescriptor } 示例
 * @author xschen
 * @date 2022/2/11 17:46
 * @see BeanDescriptor
 */
public class BeanDescriptorDemo {

    public static void isBeanConstrained() {
        BeanDescriptor beanDescriptor = obtainValidator().getConstraintsForClass(User.class);
        System.out.println("User.class need valid: " + beanDescriptor.isBeanConstrained());
        Set<PropertyDescriptor> propertyDescriptors = beanDescriptor.getConstrainedProperties();
        Set<MethodDescriptor> constrainedMethods = beanDescriptor.getConstrainedMethods(MethodType.GETTER);
        Set<ConstructorDescriptor> constrainedConstructors = beanDescriptor.getConstrainedConstructors();
        System.out.println("properties of need valid: " + propertyDescriptors);
        System.out.println("methods of need valid: " + constrainedMethods);
        System.out.println("constructors of need valid: " + constrainedConstructors);

        PropertyDescriptor fullNameDesc = beanDescriptor.getConstraintsForProperty("fullName");
        System.out.println(fullNameDesc);
        System.out.println("the number of fullName property: " + fullNameDesc.getConstraintDescriptors().size());
    }

    public static void main(String[] args) {
        isBeanConstrained();
    }
}
