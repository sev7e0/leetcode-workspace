/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int head = 1;
        int tail = nums.length - 2;
        while (head <= tail) {
            // 若满足左右两边小于当前值那么判定为峰值
            if (nums[head - 1] < nums[head] && nums[head] > nums[head + 1]) {
                return head;
            }
            // 如果当前值大于右边，则表示下一个值不会成为峰值，可以直接跳过
            if (nums[head] >= nums[head + 1]) {
                head += 2;
            } else {
                // 否则可以继续判断
                head++;
            }
        }
        // 此时说明数组元素有序，直接比较头尾两个部分哪个大哪个为峰值
        if (nums[0] > nums[nums.length - 1]) {
            return 0;
        }
        return nums.length - 1;
    }
}
// @lc code=end
