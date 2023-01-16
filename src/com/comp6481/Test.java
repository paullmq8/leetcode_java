package com.comp6481;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        String[] strings = new String[]{"a", "b", "c"};
        Stream<String> stream = Stream.of(strings);
        Stream<String> stream1 = Arrays.stream(strings);
        String[][] strings2 = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        Stream<String> stream2 = Stream.of(strings2).flatMap(Stream::of);
        List<List<String>> doubleList = new ArrayList<>();
        doubleList.add(Arrays.asList("a", "b", "c"));
        doubleList.add(Arrays.asList("d", "e", "f"));
        doubleList.add(Arrays.asList("g", "h", "i"));
        doubleList.stream().flatMap(List::stream);

        System.out.println("==============");
        TreeMap<Integer, String> treeMap = new TreeMap<>(Comparator.comparingInt(Integer::intValue));
        treeMap.put(1, "a");
        treeMap.put(2, "b");
        treeMap.put(3, "b");
        treeMap.put(5, "c");
        treeMap.put(6, "c");
        treeMap.put(8, "c");
        System.out.println(treeMap);
        System.out.println(treeMap.firstEntry());
        System.out.println(treeMap.lastEntry());
        System.out.println(treeMap.floorEntry(4));
        System.out.println(treeMap.ceilingEntry(7));
    }
}
