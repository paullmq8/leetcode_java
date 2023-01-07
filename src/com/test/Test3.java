package com.test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test3 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        while (!deque.isEmpty()) {
            System.out.println(deque.pop());
        }
    }
}
