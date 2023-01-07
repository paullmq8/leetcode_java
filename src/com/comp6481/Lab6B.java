package com.comp6481;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab6B {

    private static Map<String, List<String>> process(List<String> nameList, int index) {
        Map<String, List<String>> map = new HashMap<>();
        for (String name : nameList) {
            if (name.length() >= index) {
                String prefix = name.substring(0, index);
                if (!map.containsKey(prefix)) {
                    map.put(prefix, new ArrayList());
                }
                map.get(prefix).add(name);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = scanner.nextLine();
        }
        List<String> nameList = Arrays.stream(names).collect(Collectors.toList());
        List<Map.Entry<String, List<String>>> result = new ArrayList<>();
        int index = 1;
        do {
            Map<String, List<String>> map = process(nameList, index++);
            result.addAll(map.entrySet().stream().filter(entry -> entry.getValue().size() == 1).collect(Collectors.toList()));
            nameList.removeAll(map.entrySet().stream().filter(entry -> entry.getValue().size() == 1).map(entry
                    -> entry.getValue()).flatMap(List::stream).collect(Collectors.toList()));
        } while(nameList.size() > 0);
        System.out.println(result.stream().mapToInt(entry -> entry.getKey().length()).sum());
    }
}
