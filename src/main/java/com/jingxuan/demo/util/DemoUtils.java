package com.jingxuan.demo.util;

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
        System.out.println(getStartIndex(1));
    }

    static Integer getStartIndex(Integer maxId) {
        if (maxId < 10000000) {
            return 0;
        }
        return maxId - (maxId % 10000000 + 10000000);
    }
}
