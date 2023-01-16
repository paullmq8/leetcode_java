package com.test_features;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.get(0));
        System.out.println(map.getOrDefault(0, -1));
    }
}
