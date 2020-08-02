/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //当数组只有一个元素时直接返回第一个元素
        if (nums.length == 1) {
            return nums[0];
        }
        int head = 0, mid = 0, tail = nums.length - 1;

        //当数组有序的时候直接返回第一个元素
        if (nums[tail]>nums[head]) {
            return nums[0];
        }

        while (head <= tail) {
            mid = head + (tail - head) / 2;

            // 终止条件
            //如果当前mid大于mid+1，则说明mid+1是最小的一位，因为整个数组有序
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // 如果当前mid 小于mid-1，那么说明他是最小的一个
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // 选择条件
            if (nums[mid] > nums[0]) {
                head = mid + 1;
              } else {
                // if nums[0] is greater than the mid value then this means the smallest value is somewhere to
                // the left
                tail = mid - 1;
              }
        }
        return -1;

        // 一次遍历：时间复杂度O(n)，空间复杂度O(1)
        // int temp = nums[0];
        // for (int i = 0; i < nums.length; i++) {
        // temp = Math.min(nums[i], temp);
        // }
        // return temp;
    }
}
// @lc code=end
