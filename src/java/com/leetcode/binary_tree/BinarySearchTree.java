package com.leetcode.binary_tree;

public class BinarySearchTree {

    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Node head;

    public BinarySearchTree(Node head) {
        this.head = head;
    }

    public Node iterativeTreeSearch(Node node, int val) {
        while (node != null && val != node.val) {
            if (val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public Node recursiveTreeSearch(Node node, int val) {
        if (node != null) {
            if (val < node.val) {
                node = recursiveTreeSearch(node.left, val);
            } else if (val > node.val) {
                node = recursiveTreeSearch(node.right, val);
            }
        }
        return node;
    }

    public void recursiveTreePrint(Node node) {
        if (node == null) return;
        System.out.println(node.val);
        recursiveTreePrint(node.left);
        recursiveTreePrint(node.right);
    }
}
