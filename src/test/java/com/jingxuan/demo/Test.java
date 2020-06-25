package com.jingxuan.demo;

/**
 * @Author: Xuan Jing
 * @Date: 2020/6/13 8:56 PM
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Test.class.getClassLoader().getResource("test.sh").getPath());

        try {
            TestUtil testUtil = (TestUtil) Test.class.getClassLoader().loadClass("com.jingxuan.demo.TestUtil").newInstance();
            testUtil.print();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
