/*
 * @lc app=leetcode.cn id=189 lang=java
 * @lcpr version=30201
 *
 * [189] 轮转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        k = k % nums.length;
        revers(nums, 0, nums.length - 1);
        revers(nums, 0, k - 1);
        revers(nums, k, nums.length - 1);
    }

    public void revers(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4,5,6,7]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1,-100,3,99]\n2\n
 * // @lcpr case=end
 * 
 */
