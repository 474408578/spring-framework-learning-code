package com.xschen.spring.resource;

import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * @author xschen
 */


public class DogProtocolResolver implements ProtocolResolver {
    private static final String DOG_PATH_PREFIX = "dog:";

    @Override
    public Resource resolve(String s, ResourceLoader resourceLoader) {
        if (!s.startsWith(DOG_PATH_PREFIX)) {
            return null;
        }

        // 去掉自定义前缀
        String realPath = s.substring(DOG_PATH_PREFIX.length());
        String classPathLocation = "classpath:resource/" + realPath;
        return resourceLoader.getResource(classPathLocation);

    }
}
