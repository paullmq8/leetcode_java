package com.leetcode.binary_search_tree;
/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private boolean found = false;
    private int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        inOrderDfs(root, k);
        return res;
    }
    private void inOrderDfs(TreeNode node, int k) {
        if (node == null) return;
        if (!found) inOrderDfs(node.left, k);
        if (k == 1) {
            found = true;
            res = node.val;
            k--;
            return;
        }
        k--;
        if (!found) inOrderDfs(node.right, k);
    }
}
// @lc code=end
