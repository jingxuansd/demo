package com.jingxuan.demo.util;

/**
 * @Author: Xuan Jing
 * @Date: 2020/3/10 4:50 PM
 */
final class DemoUtils {

    static {
        System.out.println("DemoUtils init.");
    }


    public static void main(String[] args) {
        printFun(null);
    }

    private static void printFun(String fun) {
        if (fun == null) {
            throw new RuntimeException("The function input is null.");
        }
        System.out.println(fun.length());
    }
}
