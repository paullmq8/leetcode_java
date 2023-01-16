package com.leetcode.two_pointers.valid_palindrome_II;
/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start

class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, h = s.length() - 1;
        while (l < h && s.charAt(l) == s.charAt(h)) {
            l++;
            h--;
        }
        if (l >= h) return true;
        return isPalin(s, l + 1, h) || isPalin(s, l, h - 1);
    }
    private boolean isPalin(String s, int l, int h) {
        while (l < h && s.charAt(l) == s.charAt(h)) {
            l++;
            h--;
        }
        if (l >= h) return true;
        return false;
    }
}

/*
class Solution {
    private boolean isDeleted = false;
    public boolean validPalindrome(String s) {
        int l = 0, h = s.length() - 1;
        while (l < h) {
            if (s.charAt(l) != s.charAt(h)) {
                if (isDeleted) {
                    return false;
                }
                isDeleted = true;
                return validPalindrome(s.substring(0, l) + s.substring(l + 1, s.length())) 
                || validPalindrome(s.substring(0, h) + s.substring(h + 1, s.length()));
            }
            l++;
            h--;
        }
        return true;
    }
}
*/

// @lc code=end

