package com.leetcode.util;

import java.util.Arrays;

/**
 * N * 2 == N << 1
 * N / 2 == N >> 1
 * N * 2 + 1 == N << 1 | 1
 * -N = ~N + 1 (exception: ~Integer.MIN_VALUE + 1 = Integer.MIN_VALUE)
 * Integer.MIN_VALUE = -Integer.MIN_VALUE
 */
public class LeetcodeUtil {

    public static final int TEST_COUNT = 10000;
    public static final int LOW = 0;
    public static final int HIGH = 1000;
    public static final int MAX_LENGTH = 10000;

    public static void main(String[] args) {
        System.out.println(3 | 1);
        System.out.println((3 << 1) | 1);
        int min = Integer.MIN_VALUE;
        System.out.println(min);
        System.out.println(-1 * min);
        System.out.println(toBinaryString(-5));
        System.out.println(toBinaryString(1));
        System.out.println(toBinaryString(5));
        System.out.println(toBinaryString(~5));
        System.out.println(~5 + 1);
        System.out.println(~(-5) + 1);
        Runnable r = () -> System.out.println("Hello world!");
        System.out.println(r);
//        Object o = () -> System.out.println("aa");
    }

    public static void standardSort(int[] array) {
        Arrays.sort(array);
    }

    public static void swap(int[] array, int i, int j) {
        if (i != j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    /**
     * i and j can't be the same.
     * @param array
     * @param i
     * @param j
     */
     public static void quickSwap(int[] array, int i, int j) {
         if (i != j) {
             array[i] = array[i] ^ array[j];
             array[j] = array[i] ^ array[j];
             array[i] = array[i] ^ array[j];
         }
     }

    /**
     * The generated array may contain duplicate numbers.
     * @param low
     * @param high
     * @param maxLength
     * @return
     */
    public static int[] generateRandomArrayIncludingDuplicates(int low, int high, int maxLength) {
        if (high < low || maxLength <= 0) return null;
        int[] array = new int[maxLength];
        int interval = high - low + 1;
        for (int i = 0; i < maxLength; i++) {
            array[i] = (int) (Math.random() * interval + low);
        }
        return array;
    }

    /**
     * The generated array doesn't contain duplicate numbers.
     * @param low
     * @param high
     * @param maxLength
     * @return
     */
    public static int[] generateRandomArrayExcludingDuplicates(int low, int high, int maxLength) {
        if (high < low || maxLength <= 0 || high - low < maxLength) return null;
        int interval = (high - low) / maxLength;
        int[] array = new int[maxLength];
        array[0] = (int) (Math.random() * interval + 1);
        for (int i = 1; i < maxLength; i++) {
            array[i] = array[i - 1] + (int) (Math.random() * interval + 1);
        }
        return array;
    }

    public static int generateRandomIndex(int arrayLength) {
        return (int) (Math.random() * arrayLength);
    }

    public static boolean compareTwoArrays(int[] array1, int[] array2) {
        if (array1 == null || array2 == null || array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) return false;
        }
        return true;
    }

    public static int[] cloneArray(int[] array) {
        if (array == null) return null;
        int[] clonedArray = new int[array.length];
        System.arraycopy(array, 0, clonedArray, 0, array.length);
        return clonedArray;
    }

    public static int searchTarget(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static String toBinaryString(int number) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 31; i >= 0; i--) {
            stringBuffer.append((number & (1 << i)) == 0 ? "0" : "1");
        }
        return stringBuffer.toString();
    }
}
