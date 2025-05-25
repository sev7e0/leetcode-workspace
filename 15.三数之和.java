import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		int length = nums.length;
		List<List<Integer>> arrayList = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int k = length - 1; 
			int target = 0 - nums[i];
			for (int j = i + 1; j < length - 1; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}

				while (j < k && nums[j] + nums[k] > target) {
					k--;
				}
				if (j == k) {
					break;
				}
				if (nums[j] + nums[k] == target) {
					arrayList.add(Arrays.asList(nums[i], nums[j], nums[k]));
				}
			}
		}
		return arrayList;

	}
}
// @lc code=end

// @lc code=start
// class Solution {
// public List<List<Integer>> threeSum(int[] nums) {
// Arrays.sort(nums);
// List<List<Integer>> result = new ArrayList<>();
// Map<Integer, Integer> map = new HashMap<>();
// for (int i = 0; i < nums.length; i++) {
// if (i>0 && nums[i] == nums[i-1]) continue;
// map.put(-nums[i], i);
// }
// for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
// Integer sum = entry.getKey();
// Integer index = entry.getValue();
// Map<Integer, Integer> innerMap = new HashMap<>();
// for (int i = index+1; i < nums.length && i != index; i++) {
// int min = sum - nums[i];
// if (innerMap.containsKey(min)) {
// result.add(Arrays.asList(min, nums[i], nums[index]));
// }
// innerMap.put(nums[i], i);
// }
// }
// return result;
// }
// }
// @lc code=end