package com.think.in.spring.i18n;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * {@link MessageFormat} 使用示例
 * @author xschen
 */

public class MessageFormatDemo {

    public static void main(String[] args) {
        int planet = 7;
        String event = "a disturbance in the Force";
        String messageFormatPattern = "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.";
        MessageFormat messageFormat = new MessageFormat(messageFormatPattern);
        String result = messageFormat.format(new Object[] {planet, new Date(), event});
        System.out.println(result);

        // 重置 MessagePattern
        messageFormatPattern = "This is a text : {0}, {1}, {2}";
        messageFormat.applyPattern(messageFormatPattern);
        result = messageFormat.format(new Object[] {"Hello world", 666});
        System.out.println(result);

        // 重置 Locale
        messageFormat.setLocale(Locale.ENGLISH);
        messageFormatPattern = "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.";
        messageFormat.applyPattern(messageFormatPattern);
        result = messageFormat.format(new Object[] {planet, new Date(), event});
        System.out.println(result);

        // 重置 Format
        // 根据参数索引来设置 Pattern
        messageFormat.setFormat(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        result = messageFormat.format(new Object[] {planet, new Date(), event});
        System.out.println(result);
    }
}
