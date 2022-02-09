package com.think.in.spring.conversion;

import java.beans.PropertyEditor;

/**
 * {@link PropertyEditor} 示例
 *
 * @author xschen
 */

public class PropertyEditorDemo {

    public static void main(String[] args) {
        // 模拟 Spring Framework 操作
        String text = "name = song";
        PropertyEditor propertyEditor = new StringToPropertiesPropertyEditor();
        // 传递 String 类型的内容
        propertyEditor.setAsText(text);
        System.out.println(propertyEditor.getValue()); // {name=song}

        System.out.println(propertyEditor.getAsText()); // name=song
    }
}
