package sun.net.www.protocol.x;

import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * X Handler 测试示例
 * @author xschen
 */

public class HandlerTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("x:/META-INF/default.properties");
        InputStream inputStream = url.openStream();
        System.out.println(StreamUtils.copyToString(inputStream, Charset.forName("UTF-8")));
    }

}
