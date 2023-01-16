package com.leetcode.two_pointers.valid_palindrome;
/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    private boolean isAlphanumeric(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, h = s.length() - 1;
        boolean res = true;
        OUTER:
        while (l < h) {
            while (!isAlphanumeric(s.charAt(l))) {
                l++;
                if (l >= h) break OUTER;
            }
            while (!isAlphanumeric(s.charAt(h))) {
                h--;
                if (l >= h) break OUTER;
            }
            if (s.charAt(l) != s.charAt(h)) {
                res = false;
                break;
            }
            l++;
            h--;
        }
        return res;
    }
}
// @lc code=end

