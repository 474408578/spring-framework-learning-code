package com.think.in.spring.data.binding;

import com.think.in.spring.ioc.container.overview.domain.Company;
import com.think.in.spring.ioc.container.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link DataBinder} 示例
 *
 * @author xschen
 */


public class DataBinderDemo {

    public static void main(String[] args) {
        // 创建空白对象
        User user = new User();
        // 1、创建 DataBinder
        DataBinder binder = new DataBinder(user, "");

        // 2、创建 PropertyValues
        Map<String, Object> source = new HashMap<>();
        source.put("id", 1);
        source.put("name", "song");

        // a、PropertyValues 存在 User 中不存在的属性值
        // DataBinder 特性1： 忽略未知的属性
        source.put("age", 18);

        // b、PropertyValues 存在一个嵌套属性， 比如 company.name
        // DataBinder 特性2：支持嵌套属性

        source.put("company.name", "ctrip");

        // 1. 调整 IgnoreUnknownFields true(默认) -> false (抛出异常， age 字段不存在于 User 类)
        //binder.setIgnoreUnknownFields(false);

        // 2. 调整自动增加嵌套路径 true(默认) -> false
        //binder.setAutoGrowNestedPaths(false);
        //Company company = new Company();
        //company.setName("ctrip");
        //user.setCompany(company);

        PropertyValues propertyValues = new MutablePropertyValues(source);
        binder.bind(propertyValues);

        // 3. 调整 IgnoreInvalidFields false（默认） -> true
        binder.setIgnoreUnknownFields(true);


        // 3、输出 User 内容
        System.out.println(user);

        // 4、获取绑定结果（结果包含错误文案 code, 不会抛异常）
        BindingResult result = binder.getBindingResult();
        System.out.println(result);
    }
}
