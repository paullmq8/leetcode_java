package com.leetcode.trie;

public class TrieNode {

    TrieNode[] children;
    boolean isWord;

    TrieNode() {
        children = new TrieNode[26];
    }
}
