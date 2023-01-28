package com.leetcode.two_pointers.valid_word_abbreviation;
/*
 * @lc app=leetcode id=408 lang=java
 *
 * [408] Valid Word Abbreviation
 *
 */

// @lc code=start
class Solution {
    private boolean prevDigit = false;
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        for (; i < word.length() && j < abbr.length(); i++, j++) {
            char wc = word.charAt(i);
            char ac = abbr.charAt(j);
            if (Character.isAlphabetic(ac)) {
                if (wc == ac) {
                    prevDigit = false;
                    continue;
                } else return false;
            }
            int d = Integer.parseInt(String.valueOf(ac));
            if (!prevDigit && d == 0) return false;
            StringBuffer sb = new StringBuffer();
            do {
                sb.append(d);
                j++;
                ac = abbr.charAt(j);
            } while (Character.isDigit(ac));
            i += Integer.parseInt(String.valueOf(sb));
            prevDigit = true;
        }
    }
}
// @lc code=end

