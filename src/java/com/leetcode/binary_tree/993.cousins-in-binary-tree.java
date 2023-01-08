package com.leetcode.binary_tree;
/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
 */

// @lc code=start
class Solution {

    private int parentNode = -1;
    private int height = 0;

    private boolean dfs(TreeNode node, int val) {
        if (node == null) return false;
        dfs(node.left, val) 
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        boolean xFound = dfs(root, x);
        int xParentNode = parentNode;
        int xHeight = height;
        boolean yFound = dfs(root, y);
        int yParentNode = parentNode;
        int yHeight = height;
        return xFound && yFound && xParentNode != yParentNode && xHeight == yHeight;
    }
}
/*
class Solution {
    // To save the depth of the first node.
    int recordedDepth = -1;
    boolean isCousin = false;

    private boolean dfs(TreeNode node, int depth, int x, int y) {

        if (node == null) {
            return false;
        }

        // Don't go beyond the depth restricted by the first node found.
        if (this.recordedDepth != -1 && depth > this.recordedDepth) {
            return false;
        }

        if (node.val == x || node.val == y) {
            if (this.recordedDepth == -1) {
                // Save depth for the first node found.
                this.recordedDepth = depth;
            }
            // Return true, if the second node is found at the same depth.
            return this.recordedDepth == depth;
        }

        boolean left = dfs(node.left, depth + 1, x, y);
        boolean right = dfs(node.right, depth + 1, x, y);

        // this.recordedDepth != depth + 1 would ensure node x and y are not
        // immediate child nodes, otherwise they would become siblings.
        if (left && right && this.recordedDepth != depth + 1) {
            this.isCousin = true;
        }
        return left || right;
    }

    public boolean isCousins(TreeNode root, int x, int y) {

        // Recurse the tree to find x and y
        dfs(root, 0, x, y);
        return this.isCousin;
    }
}
*/
// @lc code=end

