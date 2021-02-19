package com.think.in.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * 带有字符编码的 {@link FileSystemResource} 示例
 * @author xschen
 */

public class EncodedFileSystemResourceDemo {

    public static void main(String[] args) {
        // System.getProperty("user.dir")： 当前工程路径
        String currentJavaFilePath = System.getProperty("user.dir") + "/resource/src/main/java/com/think/in/spring/resource/EncodedFileSystemResourceDemo.java";
//        File currentJavaFile = new File(currentJavaFilePath);
        // FileSystemResource ==> WritableResource ==> Resource
        FileSystemResource fileSystemResource = new FileSystemResource(currentJavaFilePath);
        EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");

        // 字符输入流
        try (Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
