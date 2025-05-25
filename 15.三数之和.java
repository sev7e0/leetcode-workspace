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
		// 时间复杂度：O(n2)
		// 空间复杂度：O(1)
		int length = nums.length;
		// 先进行排序 要得到有序数组才可以进行操作
		Arrays.sort(nums);
		List<List<Integer>> reList = new ArrayList<>();
		for (int i = 0; i < length - 2; i++) {
			// 去重过程
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			// 优化 前三个大于0那说明后边没有合适结果，直接跳出
			if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
				break;
			}
			// 优化 第一个加最后两个小于零，那说明本次循环没有合适结果，可以进行下次循环，i++
			if (nums[i] + nums[length - 1] + nums[length - 2] < 0) {
				continue;
			}
			int k = length - 1;
			int target = 0 - nums[i];
			for (int j = i + 1; j < length - 1; j++) {
				// 去重过程
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				// 和大于target时k向右移动
				while (j < k && nums[j] + nums[k] > target) {
					k--;
				}
				// 相等时直接跳出 j ++
				if (j == k) {
					break;
				}
				// 等于target时添加结果即可
				if (nums[j] + nums[k] == target) {
					reList.add(Arrays.asList(nums[i], nums[j], nums[k]));
				}

			}
		}

		return reList;
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