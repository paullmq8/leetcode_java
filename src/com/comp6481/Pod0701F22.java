package com.comp6481;

/*
Equal Sum Queues
Given two queues, we need to find minimum number of operations that could make the two queues’
sum is equal. The operation is set of pop in one queue and insert into another queue. For example, if
we have A: [3 2 3], B: [ 2 1 1] then POP A, INSERT B will give A: [2 3] B: [2 1 1 3], POP B, INSERT A
will give A: [2 3 2], B: [1 1 3], POP B, INSERT A will gives A: [2 3 2 1] B: [1 3], then POP A, INSERT B
will give A: [3 2 1], B: [1 3 2]. Now, Each queue have same sum, therefore the minimum of operation
require is 4.
Input:
1. First queue, integer numbers with space separated
2. Second queue, integer numbers with space separated
Output:
1. Minimum number of operations that gives same sum of two queues or if the two queue could not have
same sum, return -1.
Sample:

No. Sample Input Sample Output
1 | 3 2 7 2
4 6 5 1 | 2
2 | 1 10 1 2
1 2 1 2 | 7
3 | 1 2
1 5 | -1
 */
public class Pod0701F22 {
}
