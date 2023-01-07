package com.test;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        String v1 = map.put(1, "1");
        System.out.println(v1);
        String v2 = map.put(1, "2");
        System.out.println(v2);
        String v3 = map.remove(1);
        System.out.println(v3);
    }
}
