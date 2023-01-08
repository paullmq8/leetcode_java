package com.comp6481;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 3, 1, 9};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
