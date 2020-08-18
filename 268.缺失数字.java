/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 缺失数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int[] temp = new int[nums.length + 1];
        // 使用参照数组将其放置在位置上
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]] = nums[i];
        }
        for (int i = 0; i < temp.length; i++) {
            // 如果其位置上的值与位置不对应，那么判定其不存在
            if (temp[i] != i) {
                return i;
            }
        }
        // 全部都存在的话那么说明是0
        return 0;
    }
}
// @lc code=end
