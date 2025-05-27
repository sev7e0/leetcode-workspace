/*
 * @lc app=leetcode.cn id=560 lang=java
 * @lcpr version=30201
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int l = nums.length;
        int[] s = new int[l + 1];
        for (int i = 0; i < nums.length; i++) {
            s[i + 1] = s[i] + nums[i];
        }

        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(l + 1);
        // nums[right + 1] - nums[i] = k
        for (int num : s) {
            ans += map.getOrDefault(num - k, 0);
            map.merge(num, 1, Integer::sum);
        }
        return ans;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,1,1]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3]\n3\n
 * // @lcpr case=end
 * 
 */
