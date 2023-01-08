package com.leetcode.binary_tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BFS {
    public static void bfs(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.printf(temp.val + " ");
            if (Objects.nonNull(temp.left)) queue.offer(temp.left);
            if (Objects.nonNull(temp.right)) queue.offer(temp.right);
        }
        System.out.println();
    }
}
