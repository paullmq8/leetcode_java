package com.comp6481;

/*
A message containing letters from A-Z can be encoded into numbers using the following mapping:
'A' -> "1"
'B' -> "2"
.
.
.
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters
using the reverse of the mapping above (there may be multiple ways).
For example, "11106" can be mapped into:
"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is
different from "06". Given a string s containing only digits, return the number of ways to decode
it. The test cases are generated so that the answer fits in a 32-bit integer.
Input consists of String s.
Output the total number of decoded ways.
Integer

Input Output Explanation
12 | 2 | "12" could be decoded as "AB" (1 2) or "L" (12).
06 | 0 | "06" cannot be mapped to "F"
because of the leading zero ("6"
is different from "06").
 */
public class Pod0902F22 {
}
