package com.comp6481;

/*
Find steepest peak

A point is peak, if ai-1 < ai > ai+1 and we check the steepness of peak by
formula max( |ai-1 - ai|, | ai - ai+1 |). You have to find a peak which is
steepest.
i.e. max(max( |ai-1 - ai|, | ai - ai+1 |), for all 1 from 1 to n-1)

Input:
The first line contains one positive integer, indicating the N Length of array and .
After the first line, the list of elements of the array is given separated by “,”
without any space.
First and last element of the array will always be 0.

Output:
Single integer from 0 to N representing index of peak. -1 if there is no peak.

Sample Input | Sample Output
7
0,1,2,3,2,1,0 | 3
7
0,1,7,3,8,1,0 | 4
8
0,12,17,13,7,8,1,0 | 5
 */
public class Pod0302F22 {
}
