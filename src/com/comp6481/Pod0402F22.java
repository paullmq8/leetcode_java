package com.comp6481;

/*
Maintain the Queue.
People are standing in a queue and only people who are given a token can
stand in the queue. People without a token have to wait at the end of the
queue.
But a lot of people without a token are standing before people with a
token in the queue. So, you have to move people without a token to the
end of the queue and also maintain the order in which people with the
token are standing in the queue.
Input:
The first line contains one positive integer, indicating the N Length of array and .
After the first line, the list of elements of the array is given separated by “,”
without any space.
Number in the array represents the token number of the person at that position in
the queue and where -1 represents the person without a token.
Output:
Array with all elements in the input array, where relative order is maintained for
people in the queue and all people without a token at the end of the output List.

Sample Input | Sample Output
7
-1,1,2,3,2,1,-1 | 1,2,3,2,1,-1,-1
7
-1,7,3,-1,8,1,2 | 7,3,8,1,2,-1,-1
2
-1, 0 | 0, -1
 */
public class Pod0402F22 {
}
