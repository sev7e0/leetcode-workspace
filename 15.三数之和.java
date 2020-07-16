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
		int n = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		// 枚举 a
		for (int first = 0; first < n-2; ++first) {
			// 需要和上一次枚举的数不相同
			if (first > 0 && nums[first] == nums[first - 1]) {
				continue;
			}
			// c 对应的指针初始指向数组的最右端
			int third = n - 1;
			int target = -nums[first];
			// 枚举 b
			for (int second = first + 1; second < n-1; ++second) {
				// 需要和上一次枚举的数不相同
				if (second > first + 1 && nums[second] == nums[second - 1]) {
					continue;
				}
				// 需要保证 b 的指针在 c 的指针的左侧
				while (second < third && nums[second] + nums[third] > target) {
					--third;
				}
				// 如果指针重合，随着 b 后续的增加
				// 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
				if (second == third) {
					break;
				}
				if (nums[second] + nums[third] == target) {
					ans.add(Arrays.asList(nums[first],nums[second],nums[third]));
				}
			}
		}
		return ans;
    }
}
// @lc code=end

// @lc code=start
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);
// 		List<List<Integer>> result = new ArrayList<>();
// 		Map<Integer, Integer> map = new HashMap<>();
// 		for (int i = 0; i < nums.length; i++) {
// 			if (i>0 && nums[i] == nums[i-1]) continue;
// 			map.put(-nums[i], i);
// 		}
// 		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
// 			Integer sum = entry.getKey();
// 			Integer index = entry.getValue();
// 			Map<Integer, Integer> innerMap = new HashMap<>();
// 			for (int i = index+1; i < nums.length && i != index; i++) {
// 				int min = sum - nums[i];
// 				if (innerMap.containsKey(min)) {
// 					result.add(Arrays.asList(min, nums[i], nums[index]));
// 				}
// 				innerMap.put(nums[i], i);
// 			}
// 		}
// 		return result;
//     }
// }
// @lc code=end