package sun.net.www.protocol.x;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * Java 标准资源管理扩展
 * 简易实现：实现 URLStreamHandler 并放置在 sun.net.www.protocol.${protocol}.Handler 包下
 *
 * X 协议 {@link URLStreamHandler} 实现
 * @author xschen
 */


public class Handler extends URLStreamHandler {
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return new XURLConnection(u);
    }
}
