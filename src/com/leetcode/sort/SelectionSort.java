package com.leetcode.sort;

import java.util.Arrays;

import static com.leetcode.util.LeetcodeUtil.LOW;
import static com.leetcode.util.LeetcodeUtil.MAX_LENGTH;
import static com.leetcode.util.LeetcodeUtil.TEST_COUNT;
import static com.leetcode.util.LeetcodeUtil.HIGH;
import static com.leetcode.util.LeetcodeUtil.cloneArray;
import static com.leetcode.util.LeetcodeUtil.compareTwoArrays;
import static com.leetcode.util.LeetcodeUtil.generateRandomArrayIncludingDuplicates;
import static com.leetcode.util.LeetcodeUtil.standardSort;
import static com.leetcode.util.LeetcodeUtil.swap;

public class SelectionSort {

    public static void main(String[] args) {
        for (int i = 0; i < TEST_COUNT; i++) {
            int[] originalArray = generateRandomArrayIncludingDuplicates(LOW, HIGH, MAX_LENGTH);
            int[] array = cloneArray(originalArray);
            int[] clonedArray = cloneArray(originalArray);
            mySelectionSort(array);
            standardSort(clonedArray);
            if (!compareTwoArrays(array, clonedArray)) {
                System.out.println(Arrays.toString(originalArray));
                return;
            }
        }
        System.out.println("Success!");
    }

    public static void bestSelectionSort(int[] array) {
        if (array == null || array.length == 0) return;

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[minIndex] > array[j] ? j : minIndex;
            }
            swap(array, i, minIndex);
        }
    }

    public static void mySelectionSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }
}
