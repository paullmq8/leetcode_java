package com.comp6481;

/*
Triangle with widest base

A array create triangle if:
1. All the elements of array are either strictly increasing i.e. ai-1 < ai
2. Or All the elements of array are either strictly decreasing i.e. ai-1 >
ai
.
3. Or All the elements of array follows this sequence ai-1 < ai and ai+1 <
ai where 1<=i<n (n is the length of array).

Problem:
Given an array, we have to return the length of the longest subarray that
creates a triangle else return 0.

Input:
The first line contains one positive integer, indicating the N Length of array and .
After first line, list of elements of array is given separated by “,” without any space

Output:
Length of maximum subarray that create triangle

Sample Input | Sample Output | explanation
7
0,1,2,3,2,1,0 | 7 | Here, We have one triangle and the width of the triangle is 7. So, the widest triangle is of length 7.

10
0,1,2,3,2,1,0,4,7,6 | 7 | Here, We have 2 triangles, one is [ 0, 1, 2, ,3 ,2,1,0] and another is [4,7,6 ]. So, the widest triangle is 7.

9
0,1,2,3,3,4,5,7,6 | 5 | Here, We have 2 triangles, one is [ 0, 1, 2, 3] and another is [3,4,5,7,6 ]. So, the widest triangle is of length 5.

5
0,1,2,3,3 | 4 | Here, We have one triangle [0,1,2,3] and the width of the triangle is 4. So, the widest triangle is of length 4.
 */
public class Pod0103F22 {
}
