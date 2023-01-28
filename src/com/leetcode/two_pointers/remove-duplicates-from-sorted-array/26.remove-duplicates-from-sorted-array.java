/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) nums[++i] = nums[j];
        }
        return i + 1;
    }
}

/*
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int i = 0, j = 1;
        do {
            if (nums[i] == nums[j]) j++;
            else nums[++i] = nums[j++];
        } while (j < nums.length);
        return i + 1;
    }
}
*/
// @lc code=end

