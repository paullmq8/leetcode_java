package com.leetcode.pq;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(3);
        pq.offer(35);
        pq.offer(6);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

        System.out.println("============");

//        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.offer(3);
        pq2.offer(35);
        pq2.offer(6);
        System.out.println(pq2.peek());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());

        System.out.println("============");

        PriorityQueue<Integer> pq3 = new PriorityQueue<>(3);
        System.out.println(pq3.offer(3));
        System.out.println(pq3.offer(3));
        System.out.println(pq3.offer(3));
        System.out.println(pq3.offer(3));
        System.out.println(pq3.add(3));

        System.out.println("============");

        Queue<Integer> q = new ArrayDeque<>(3);
        q.offer(3);
        q.offer(3);
        q.offer(3);
        q.offer(3);
        q.offer(3);

        System.out.println("============");

        Set<Integer> set = new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(2));
        System.out.println(set.remove(1));
        System.out.println(set.remove(3));
        System.out.println(set.contains(2));
        System.out.println(set.contains(1));
        System.out.println(set.add(3));
        System.out.println(set.add(3));
        System.out.println(set.add(3));
    }
}
