package com.comp6481;

/*
Blacklist
There was an event in a big store and the manager of the store discovered that there were several customers who
tried to win the event in an unusual way. Therefore, the manager collected the customers’ ID and put them
under “blacklist”. Then manager wanted to share the list with the judges of the event, so that the judges can
exclude the customers who are on the blacklist when deciding the winner of the event. However, the manager at
the same time wanted to protect personal information of the blacklisted customers, so the manager replaces some
characters in the user ID with ‘*’. For example, the manager found that the customers with IDs ‘aeNqA’ and
‘LsDR0’ foul played, so hand the two following IDs to the judges – ‘a*N*A’ and ‘**DR0’. Later the manager
figured out that when constructed in this way, there can be more than one set of customers that can be eliminated
from the winners. If the original (full) list was [aeNqA, hRkWp, LsDR0, aBNaA, EdqYS], then it is possible that
the judges may think they should eliminate either [aeNqA, LsDR0] or [aBNaA, LsDR0]. In this case, there are
TWO possible sets.
Find the possible number of sets from the following given inputs.

Input:
• List of customer ID who enter the event and list of ID in blacklist with ‘*’s, line separately
• ID could contain lower and uppercase of alphabet and numbers

Output:
• Number of possible lists that could make from given two list

Sample:
No. | Sample Input | Sample Output
1 | [abc abc123] [***] | 1
2 | [aeNqA hRkWp LsDR0 aBNaA EdqYS] [a*N*A **DR0] | 2
3 | [hD4M GaE7R esF1J N4C Ic0 MgXa rooNi hD99] [hD** ***] | 4
 */
public class Pod0301F22 {
}
