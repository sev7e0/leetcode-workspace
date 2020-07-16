import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */
// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length <= 4) {
            if (nums.length == 4 && nums[0] +nums[1] +nums[2] + nums[3] == target) {
                ans.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            }
            return ans;
        }
        int length = nums.length;
		Arrays.sort(nums);
		for (int a = 0; a < length; a++) {
			if (a > 0 && nums[a] == nums[a - 1])
				continue;
			for (int b = a + 1; b < length; b++) {
				if (b > a+1 && nums[b] == nums[b - 1])
					continue;
				int left = b + 1;
				int right = length - 1;
				while (left < right) {
					if (nums[a] +nums[b] +nums[left] + nums[right] > target) {
						right--;
					} else if (nums[a] +nums[b] +nums[left] + nums[right] < target) {
						left++;
					} else {
						ans.add(Arrays.asList(nums[a], nums[b], nums[left], nums[right]));
						while (left < right && nums[left] == nums[left + 1]) {
							left++;
						}
						while (left < right && nums[right] == nums[right - 1]) {
							right--;
						}
						left++;
					}

				}

			}
		}
		return ans;
    }
}
// @lc code=end
