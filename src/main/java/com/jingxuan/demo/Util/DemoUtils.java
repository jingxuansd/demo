package com.jingxuan.demo.Util;

/**
 * @Author: Xuan Jing
 * @Date: 2020/3/10 4:50 PM
 */
public final class DemoUtils {

    static {
        System.out.println("DemoUtils init.");
    }

    private static final String DEMO = "demo";

    public static void main(String[] args) {
        System.out.println(DemoUtils.DEMO);
    }
}
