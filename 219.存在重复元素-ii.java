import java.util.LinkedHashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> temp = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                for (int j = i-1; j >= i-k; j--) {
                    if (nums[j] == nums[i]) {
                        return true;
                    }
                    continue;
                }
            }
            temp.add(nums[i]);
        }
        return false;
    }
}
// @lc code=end

