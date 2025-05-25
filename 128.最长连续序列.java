/*
 * @lc app=leetcode.cn id=128 lang=java
 * @lcpr version=30201
 *
 * [128] 最长连续序列
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (Integer integer : nums) {
            set.add(integer);
        }

        int res = 0;

        for (Integer num : set) {
            if (set.contains(num -1)) {
                continue;
            }
            int count = 1;
            while (set.contains(++num)) {
                count ++;
            }

            res = Math.max(count, res);
        }
        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [100,4,200,1,3,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,3,7,2,5,8,4,6,0,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,0,1,2]\n
 * // @lcpr case=end
 * 
 */
