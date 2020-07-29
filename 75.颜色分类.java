/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int head=0;
        int tail = nums.length -1;
        int index = head;
        while (index <= tail) {
            if (nums[index] == 0) {
                swap(nums, index++, head++);
            }else if (nums[index] == 2) {
                swap(nums, index, tail--);
            }else index++;
        }

    }

    private void swap(int[] nums, int index, int head) {
        int temp = nums[index];
        nums[index] = nums[head];
        nums[head] = temp;
    }
}
// @lc code=end

