package com.test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {

    public static void main(String[] args) {
       int[] arr = {3, 3, 7, 9, 3, 2, 1, 9, 8};
       int k = 7;
       System.out.println(topKMax(arr, k));
    }

    public static int topKMax(int[] arr, int k) {
        if (arr == null || arr.length < k) return -1;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());
        int count;
        int l = 0;
        for (int i : arr) {
            count = !treeMap.containsKey(i) ? 0 : treeMap.get(i);
            treeMap.put(i, ++count);
        }
        /*int count = 0;
        for (int i = 0; i < treeMap.; i++) {
            
        }
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() > k) {
                
            }
        }*/
        return 1;
    }
}
