import java.util.Arrays;
import java.util.HashSet;


/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

		if (nums1 == null || nums2 == null) {
			return new int[0];
		}
		HashSet<Integer> res = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
		if (nums1.length>nums2.length) {
			for (int i = 0; i < nums2.length; i++) {
				if (binarySearch(nums1, nums2[i])) {
					res.add(nums2[i]);
				}
			}
		}else{
			for (int i = 0; i < nums1.length; i++) {
				if (binarySearch(nums2, nums1[i])) {
					res.add(nums1[i]);
				}
			}
		}
		int[] r = new int[res.size()];
		int index = 0;
		for (int i : res) {
			r[index++] = i;
		}
		return r;
	}

	boolean binarySearch(int[] nums, int target){
		int head = 0;
		int tail = nums.length-1;
		while (head<=tail) {
			int mid = (head+tail)>>>1;
			if (nums[mid] == target) {
				return true;
			}
			if (target> nums[mid]) {
				head = mid+1;
			}else{
				tail = mid-1;
			}
		}
		return false;
	}
}
// @lc code=end

