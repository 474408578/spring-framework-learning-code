package com.think.in.spring.conversion;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.Properties;

/**
 * String -> Properties {@link PropertyEditor}
 * @author xschen
 * @see PropertyEditor
 */


public class StringToPropertiesPropertyEditor extends PropertyEditorSupport {

    // 1. 实现 setAsText(String) 方法
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Properties properties = new Properties();
        try {
            // 2. 将 String 类型转化为 Properties 类型
            properties.load(new StringReader(text));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        // 3. 临时存储 Properties 对象
        setValue(properties);
        // next 获取临时 Properties 对象 #getValue();
    }

    @Override
    public String getAsText() {
        Properties properties = (Properties) getValue();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            sb.append(entry.getKey())
                    .append("=")
                    .append(entry.getValue())
                    .append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
