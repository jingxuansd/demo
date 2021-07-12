package com.jingxuan.demo;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsTest {
    @Test
    public void test() {
        List<String> userName = Arrays.asList("jing", "jing", "yi", "ling", "fan");
        Map<String, Integer> map = userName.stream().collect(Collectors.toMap(Function.identity(), String::length, (o1, o2) -> o1));
        System.out.println(new Gson().toJson(map));
    }

    @Test
    public void test_1() throws FileNotFoundException {
        File file = new File("test.xml");
        if (true) {
            throw new FileNotFoundException("test");
        }
    }

    @Test
    public void test_2() {
        File file = new File("test.xml");
        if (true) {
            throw new BisException("test");
        }
    }
    
    static class BisException extends RuntimeException {
        public BisException() {
            super();
        }

        public BisException(String message) {
            super(message);
        }
    }
}
