/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int head = 0;
        int tail = nums.length-1;
        int mid = 0;
        while (head <= tail) {
            mid = head + (tail - head)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[head]) {
                head++;
                continue;
            }
            //判断左右半部分有序性
            if (nums[head]>nums[mid]) {
                //右侧有序
                if (nums[mid]<target && target <= nums[tail]) {
                    head = mid+1;
                }else{
                    tail = mid-1;
                }
            }else{
                //左侧有序
                if (nums[mid]>target && target>=nums[head]) {
                    tail = mid-1;
                }else{
                    head = mid+1;
                }
            }
        }
        return false;
    }
}
// @lc code=end

