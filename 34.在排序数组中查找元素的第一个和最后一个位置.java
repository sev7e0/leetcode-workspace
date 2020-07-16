/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
		int length = nums.length;
		if (length == 0) return new int[]{-1,-1};
		int low = 0;
		int high = length-1;
		while (low <=high){
			int mid = low + (high - low)/2;
			if (nums[mid] == target){
				low = mid;
				high = mid;
				while (low >= 1 && nums[low-1] == target){
					low--;
				}
				while (high<length-1 && nums[high+1] ==target){
					high++;
                }
				return new int[]{low, high};
			}else if(nums[mid] > target){
				high = mid-1;
			}else{
				low = mid+1;
			}
		}
		return new int[]{-1, -1};
    }
}
// @lc code=end

