/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length==0) return -1;
        int right = length-1;
        int left = 0;
        while (left <= right) {
            int mid = (right-left)>>1 + left;
            if (nums[mid] == target) return mid;
            //如果左边有序，判断mid是够在左侧
            if (nums[left]<= nums[mid]) {
                if (nums[left]<=target && nums[mid]>target) {
                    right = mid-1;
                }else{
                    left = mid + 1;
                }
            //midq在右边，不过右边不一定有序
            }else{
                if (nums[right]>=target && nums[mid]<target) {
                    left = mid+1;
                }else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

