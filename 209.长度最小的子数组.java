/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length ==0) {
            return 0;
        }
        int a = 0, b= 0;
        int length = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (b<length) {
            if (nums[b] == s) {
                return 1;
            }
            sum += nums[b++];
            while (s <= sum) {
                min = Math.min(min, b - a);
                sum -= nums[a++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
// @lc code=end

