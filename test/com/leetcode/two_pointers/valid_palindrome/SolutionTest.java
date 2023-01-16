package com.leetcode.two_pointers.valid_palindrome;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class SolutionTest {
    @Test
    @DisplayName("1st example")
    public void test() {
        Solution solution = new Solution();
        assertEquals(solution.isPalindrome("A man, a plan, a canal: Panama"), true);
        assertEquals(solution.isPalindrome("race a car"), false);
        assertEquals(solution.isPalindrome(" "), true);
        assertEquals(solution.isPalindrome(" , ;"), true);
    }
}
