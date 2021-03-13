package com.think.in.spring.resource.springx;

import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Java 标准资源管理扩展
 * 自定义实现
 *  实现 URLStreamHandler
 *  添加 -Djava.protocol.handler.pkgs 启动参数，指向 URLStreamHandler 实现类的包下
 *  
 * 简单继承 sun.net.www.protocol.x.Handler类
 * @author xschen
 */
public class Handler extends sun.net.www.protocol.x.Handler {

    // 需要在VM Options里面指定如下参数，否则会提示找不到springx协议
    // -Djava.protocol.handler.pkgs=com.think.in.spring.resource
    public static void main(String[] args) throws IOException {
        URL url = new URL("springx:/META-INF/production.properties");
        InputStream inputStream = url.openStream();
        System.out.println(StreamUtils.copyToString(inputStream, Charset.forName("UTF-8")));
    }
}
