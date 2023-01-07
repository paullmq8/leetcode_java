package com.leetcode.binarysearch;

import java.util.Arrays;
import java.util.HashSet;

import static com.leetcode.util.LeetcodeUtil.LOW;
import static com.leetcode.util.LeetcodeUtil.TEST_COUNT;
import static com.leetcode.util.LeetcodeUtil.HIGH;
import static com.leetcode.util.LeetcodeUtil.generateRandomArrayExcludingDuplicates;
import static com.leetcode.util.LeetcodeUtil.generateRandomIndex;
import static com.leetcode.util.LeetcodeUtil.searchTarget;
import static com.leetcode.util.LeetcodeUtil.standardSort;

/**
 * find one number in a sorted array and return its index if found.
 * return -1 if not found.
 */
public class BinarySearch1 {

    public static void main(String[] args) {
        for (int i = 0; i < TEST_COUNT; i++) {
//            int[] originalArray = generateRandomArrayIncludingDuplicates(LOW, HIGH, 100);
            int[] originalArray = generateRandomArrayExcludingDuplicates(LOW, HIGH, 100);
            System.out.println(Arrays.toString(originalArray));
            standardSort(originalArray);
            int target = originalArray[generateRandomIndex(100)];
            int idx1 = binarySearch1(originalArray, 0, 100, target);
            int idx2 = binarySearch2(originalArray, 0, 100, target);
            int idx3 = binarySearch3(originalArray, 0, 100, target);
            int idx4 = searchTarget(originalArray, target);
            HashSet<Integer> set = new HashSet<>();
            set.add(idx1);
            set.add(idx2);
            set.add(idx3);
            set.add(idx4);
            if (set.size() > 1) {
                System.out.printf("%s %d %d %d %d %d", Arrays.toString(originalArray), target, idx1, idx2, idx3, idx4);
                return;
            }
        }
        System.out.println("Success!");
    }

    /**
     * There should be no duplicate numbers in the array.
     * @param array
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int binarySearch1(int[] array, int low, int high, int target) {
        if (array == null || array.length == 0 || low > high) return -1;
        while (!(high < low)) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] < target) {
                low = mid + 1;
            } else if (target < array[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * There should be no duplicate numbers in the array.
     * @param array
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int binarySearch2(int[] array, int low, int high, int target) {
        if (array == null || array.length == 0 || low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (array[mid] < target) {
            return binarySearch2(array, mid + 1, high, target);
        } else if (target < array[mid]) {
            return binarySearch2(array, low, mid - 1, target);
        }
        return mid;
    }

    /**
     * There could be duplicate numbers in the array.
     * Find the smallest number which is greater than or equal to the target.
     * @param array
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int binarySearch3(int[] array, int low, int high, int target) {
        if (array == null || array.length == 0 || low > high) return -1;
        int idx = -1;
        while (!(high < low)) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] < target) {
                low = mid + 1;
            } else {
                idx = mid;
                high = mid - 1;
            }
        }
        return idx;
    }

    /**
     * There could be duplicate numbers in the array.
     * Find the smallest number which is greater than or equal to the target.
     * @param array
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int binarySearch4(int[] array, int low, int high, int target) {
        if (array == null || array.length == 0 || low > high) return -1;
        int mid = low + ((high - low) >> 1);
        int idx = -1;
        if (array[mid] < target) {
            return binarySearch4(array, mid + 1, high, target);
        } else if (target < array[mid]) {
            return binarySearch4(array, low, mid - 1, target);
        }
        return idx;
    }
}
