package com.think.in.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * 带有字符编码的 {@link FileSystemResourceLoader} 示例
 * @author xschen
 * @see FileSystemResource
 * @see EncodedResource
 * @see FileSystemResourceLoader
 */

public class EncodedFileSystemResourceLoadereDemo {

    public static void main(String[] args) {
        // System.getProperty("user.dir")： 当前工程路径
        String currentJavaFilePath = System.getProperty("user.dir") + "/resource/src/main/java/com/think/in/spring/resource/EncodedFileSystemResourceLoadereDemo.java";
        // 新建一个 FileSystemResourceLoader 对象
        FileSystemResourceLoader loader = new FileSystemResourceLoader();
        Resource resource = loader.getResource(currentJavaFilePath);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");

        // 字符输入流
        try (Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
