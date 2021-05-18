package com.think.in.spring.conversion;

import java.beans.PropertyEditor;

/**
 * {}
 *
 * @author xschen
 */

public class PropertyEditorDemo {

    public static void main(String[] args) {
        String text = "name = song";
        PropertyEditor propertyEditor = new StringToPropertiesPropertyEditor();
        propertyEditor.setAsText(text);
        System.out.println(propertyEditor.getValue());
        System.out.println(propertyEditor.getAsText());
    }
}
