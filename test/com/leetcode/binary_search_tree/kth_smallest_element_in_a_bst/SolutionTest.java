package com.leetcode.binary_search_tree.kth_smallest_element_in_a_bst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

// 230.kth-smallest-element-in-a-bst-test.java
public class SolutionTest {
    @Test
    @DisplayName("Example 1")
    public void test() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3,
                new TreeNode(1, null,
                        new TreeNode(2, null, null)),
                new TreeNode(4, null, null));
        int expected = 1;
        int k = 1;
        int result = solution.kthSmallest(root, k);
        assertEquals(expected, result);
    }
}
