/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int stackSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[stackSize++] = nums[i];
            }
        }
        Arrays.fill(nums, stackSize, nums.length, 0);
    }
}
// @lc code=end
