/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    /**
     * 
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max= nums[0],temp=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (temp>0 ) {
                temp+=nums[i];
            }else{
                temp = nums[i]; 
            }
            max = Math.max(temp, max);
        }
        return max;
    }
}
// @lc code=end

