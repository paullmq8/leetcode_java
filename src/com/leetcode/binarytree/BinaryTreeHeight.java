package com.leetcode.binarytree;

public class BinaryTreeHeight {

    private int height = -1;
    private boolean found = false;

    /*
      1
     / \
    2   3
   /
   5
  /
  4
     */

    public static void main(String[] args) {
        TreeNode leaf = new TreeNode(4);
        TreeNode parent3 = new TreeNode(5, leaf, null);
        TreeNode parent1 = new TreeNode(2, parent3, null);
        TreeNode parent2 = new TreeNode(3);
        TreeNode root = new TreeNode(1, parent1, parent2);
        BinaryTreeHeight binaryTreeHeight = new BinaryTreeHeight();
        binaryTreeHeight.inorderNodeHeight(root, Integer.valueOf(4));
        System.out.println(binaryTreeHeight.height);
        BFS.bfs(root);
    }

    private void inorderNodeHeight(TreeNode node, int val) {
        if (node == null || found) return;
        height++;
        if (node.val == val) {
            found = true;
            return;
        }
        inorderNodeHeight(node.left, val);
        inorderNodeHeight(node.right, val);
    }
}
