package com.comp6481;

/*
Auto-Completion

The portal developer wants to add a search autocomplete function. The developer first wants to learn search
keywords entered by its users and then ultimately make suggestions (queries) for its users. For example, if ‘go’
is entered by the first user, the function will suggest the word ‘go’ to the next user the second user typed ‘g’. This
reduces the work of users - the second user does not need to type ‘o’! In addition, the function does not make
suggestions until it narrows down to one suggestion (see the example below).

For example, when the learned words were [ ‘hello’, ‘heat’, ‘hi’ ] and if another user wants to search the same
set of keywords, the user just needs to search the followings:
• search ‘hello’, the user only needs to enter up to ‘hel’
• search ‘heat’, the user only needs to enter up to ‘hea’
• search ‘hi’, user needs to enter ‘hi’

Therefore, to search the learned words one by one, user must enter 8 characters in total.

Input:
One line that contains list of words with comma separated.
There will be no repeated word in the list, and all words are with lowercase.

Output:
The number of characters must enter to the search all words in list.

Sample:
No. | Sample Input | Sample Output
1 | hi | 1
2 | hello,heat,hi | 8
3 | ab,abc | 5
4 | this,is,the,sample,input | 11
5 | mammoth,troubled,morning,discuss,river,confess,sea,drum,discussion | 25
 */
public class Pod0201F22 {
}
