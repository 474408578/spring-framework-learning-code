package com.xschen.architecture.g_logutils.utils;

import java.util.Arrays;

/**
 * @author xschen
 */


public class LogUtils {

    public static void printLog(String className, String methodName, Object... args) {
        System.out.println(className + " " + methodName + "...");
        System.out.println("参数列表： " + Arrays.toString(args));
    }
}
