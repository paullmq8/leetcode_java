package com.leetcode.binarytree;

public class CousinsInBinaryTree9935 {
    private boolean found = false;
    private TreeNode parentNode;
    private int depth = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) return false;
        preorder(root, x);
        TreeNode xParentNode = parentNode;
        int xDepth = depth;
        found = false;
        parentNode = null;
        depth = -1;
        preorder(root, y);
        TreeNode yParentNode = parentNode;
        int yDepth = depth;
        return xParentNode != yParentNode && xDepth == yDepth;
    }
    private void preorder(TreeNode node, int val) {
        if (node == null) return;

        if (node.left != null || node.right != null) parentNode = node;
        depth++;
        if (node.val == val) {
            found = true;
            return;
        }
        preorder(node.left, val);
        preorder(node.right, val);
    }

    public static void main(String[] args) {

    }
}
